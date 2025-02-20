package Hospital;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.LinkedList;

class Doctor extends Person {
    private String speciality;
    private String doctorID;
    private LinkedList<Appointment> appointments;

    public Doctor(String name, int age, String gender, String speciality, String doctorID) {
        super(name, age, gender);
        this.speciality = speciality;
        this.doctorID = doctorID;
        this.appointments = new LinkedList<>();
    }

    public String getSpeciality(){
        return this.speciality;
    }

    public String getDetails() {
        return "Doctor: " + getName() + "\n" + "Age: " + getAge() + "\n" + "Gender: " + getGender() + "\n" + "Speciality: " + speciality + "\n" + "Doctor ID: " + doctorID + "\n";
    }

    public LinkedList<Appointment> getAppointments() {
        System.out.println("Doctor " + getName() + " appointments:");
        if (appointments.isEmpty()) {
            System.out.println("No appointments");
            return null;
        }

        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + appointments.get(i).getDetails());
        }
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.addFirst(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

}
