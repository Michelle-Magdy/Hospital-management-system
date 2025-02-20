package Hospital;

import java.util.*;

public class BookAppointment {
    private static final ArrayList<String> specialities = new ArrayList<>(Arrays.asList(
            "Cardiology - Heart and cardiovascular system.",
            "Neurology - Nervous system, including the brain and spinal cord.",
            "Orthopedics - Bones, joints, and muscles.",
            "Pediatrics - Medical care for infants, children, and adolescents.",
            "Dermatology - Skin, hair, and nails.",
            "Oncology - Diagnosis and treatment of cancer.",
            "Gastroenterology - Digestive system and its disorders.",
            "Psychiatry - Mental health and behavioral disorders.",
            "Obstetrics and Gynecology (OB/GYN) - Women's health, pregnancy, and childbirth.",
            "Emergency Medicine - Immediate care for acute illnesses or injuries."
    ));

    // Function to list specialities
    private static void listSpecialities() {
        System.out.println("============== Book an appointment ==============");
        System.out.println("Available Specializations:");
        System.out.println("-------------------------------");
        for (int i=0;i<specialities.size();i++) {
            System.out.println("["+ (i +1) +"] " + specialities.get(i));
        }
    }

    public static void bookAppointmentMenu(HospitalManagementSystem hospitalManagementSystem) {
        listSpecialities();
        System.out.println("Choose a specialization: ");
        int specializationIndex = InputChecker.getIntegerBetween(1,10);
        int sizeOfDoctorsInSpecialization = hospitalManagementSystem.listDoctorsWithSpeciality(specializationIndex-1);
        System.out.println("Choose a doctor: ");
        int doctorIndex= InputChecker.getIntegerBetween(1,sizeOfDoctorsInSpecialization);
        Doctor doctor = hospitalManagementSystem.searchDoctor(specializationIndex-1, doctorIndex-1);
        LinkedList<Appointment> appointments = doctor.getAppointments();
        System.out.println("Choose an appointment: ");
        int appiontment = InputChecker.getIntegerBetween(1,appointments.size());
        Appointment appointment = appointments.get(appiontment-1);
        hospitalManagementSystem.BookAppointment(appointment,doctor);
        System.out.println("Appointment booked successfully");
        System.out.println(appointment.getDetails(hospitalManagementSystem.getCurrentPatient()));
    }
}


