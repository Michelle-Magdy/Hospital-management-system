package Hospital;

import java.util.*;

public class HospitalManagementSystem {
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;
    private ArrayList<ArrayList<Doctor>> specialities;
    private Patient currentPatient;

    public HospitalManagementSystem() {
        doctors = new ArrayList<>();
        generateDoctors(15);
        patients = new ArrayList<>();
        generatePatients(30);
        appointments = new ArrayList<>();
        generateAppointments(2, 5);
        specialities = new ArrayList<>();
        generateSpecialities();
    }
    public void setCurrentPatient(Patient patient){
        currentPatient = patient;
    }

    private ArrayList<Doctor> generateDoctors(int count) {
        String[] names = {"John", "Alice", "Robert", "Emily", "Michael", "Sophia", "David", "Olivia", "James", "Emma", "Mikhail", "Anton"};
        String[] genders = {"Male", "Female"};
        String[] specialities = {"Cardiologist", "Neurologist", "Orthopedic", "Pediatrician", "Dermatologist", "Oncologist", "Gastroenterologist", "Psychiatrist", "Obstetricsist and Gynecologist", "Emergency Doctor"};

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)];
            int age = 30 + random.nextInt(30);  // Age between 30 and 59
            String gender = genders[random.nextInt(genders.length)];
            String speciality = specialities[random.nextInt(specialities.length)];
            String doctorID = "D" + (1000 + i);  // Unique doctor ID (D1000, D1001, ...)

            doctors.add(new Doctor(name, age, gender, speciality, doctorID));
        }

        return doctors;
    }

    private ArrayList<Patient> generatePatients(int count) {
        String[] names = {"John", "Alice", "Robert", "Emily", "Michael", "Sophia", "David", "Olivia", "James", "Emma"};
        String[] genders = {"Male", "Female"};

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)];
            int age = 1 + random.nextInt(99);  // Age between 1 and 99
            String gender = genders[random.nextInt(genders.length)];
            String patientID = "P" + (2000 + i);  // Unique patient ID (P2000, P2001, ...)

            patients.add(new Patient(name, age, gender, patientID));
        }

        return patients;
    }

    private ArrayList<Appointment> generateAppointments(int min, int max) {
        Random random = new Random();

        // Iterate through each patient
        for (Patient patient : patients) {
            // Generate a random number of appointments for the current patient
            int numAppointments = min + random.nextInt(max - min + 1);

            // Create the appointments for the current patient
            for (int i = 0; i < numAppointments; i++) {
                // Select a random doctor
                Doctor doctor = doctors.get(random.nextInt(doctors.size()));

                // Generate a random date and time
                String dateTime = (10 + random.nextInt(10)) + "/" + (1 + random.nextInt(12)) + "/2025 at time: 10:" + (10 + random.nextInt(50));

                // Create the appointment
                Appointment appointment = new Appointment(dateTime, doctor, patient);

                // Book the appointment (assuming BookAppointment is a method that adds the appointment to the doctor's list)
                BookAppointment(appointment, doctor,patient);
            }
        }

        return appointments;
    }

    private ArrayList<ArrayList<Doctor>> generateSpecialities() {
        String[] specialityList = {"Cardiologist", "Neurologist", "Orthopedic", "Pediatrician", "Dermatologist",
                "Oncologist", "Gastroenterologist", "Psychiatrist", "Obstetricsist and Gynecologist", "Emergency Doctor"};

        // Initialize the specialities list with empty lists
        for (int i = 0; i < specialityList.length; i++) {
            specialities.add(new ArrayList<>());
        }

        for (Doctor doctor : doctors) {
            for (int i = 0; i < specialityList.length; i++) {
                if (doctor.getSpeciality().equals(specialityList[i])) {
                    specialities.get(i).add(doctor);
                    break;
                }
            }
        }
        return specialities;
    }

    public Doctor searchDoctor(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null; // Doctor not found
    }

    public Doctor searchDoctor(int specialityIndex, int doctorIndex) {
        return specialities.get(specialityIndex).get(doctorIndex);
    }

    public Patient searchPatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null; // Doctor not found
    }

    public Appointment searchAppointment(String appointment) {
        int index = appointments.indexOf(appointment);
        return (index != -1) ? appointments.get(index) : null;
    }

    public void BookAppointment(Appointment appointment, Doctor doctor) {
        currentPatient.addAppointment(appointment);
        doctor.addAppointment(appointment);
        appointments.add(appointment);
    }
    public void BookAppointment(Appointment appointment, Doctor doctor,Patient patient) {
        patient.addAppointment(appointment);
        doctor.addAppointment(appointment);
        appointments.add(appointment);
    }


    public void CancelAppointment(Appointment appointment) {
        currentPatient.removeAppointment(appointment);
        appointment.getDoctor().removeAppointment(appointment);
        appointments.remove(appointment);
    }

    private ArrayList<Doctor> searchDoctorsBySpeciality(int n) {
        return specialities.get(n);
    }

    public int listDoctorsWithSpeciality(int n) {
        ArrayList<Doctor> doctorSpecializationList = searchDoctorsBySpeciality(n);
        for (int i = 0; i < doctorSpecializationList.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + doctorSpecializationList.get(i).getDetails());
        }
        return doctorSpecializationList.size();
    }

    public Patient getCurrentPatient() {
        return currentPatient;
    }
}
