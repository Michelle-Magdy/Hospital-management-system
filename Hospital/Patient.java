package Hospital;

import java.util.ArrayList;
import java.util.LinkedList;

class Patient extends Person {
    private String patientID;
    private LinkedList<Appointment> appointments;

    public Patient(String name, int age, String gender,String patientID) {
        super(name, age, gender);
        this.patientID = patientID;
        this.appointments = new LinkedList<>();
    }
    public String getDetails(){
        return "Patient: " + getName() +"\n"+"Age: " + getAge() +"\n" + "Gender: " + getGender() +"\n" + "Patient ID: " + patientID +"\n";
    }
    public void getAppointments(){
        for(Appointment appointment: appointments){
            System.out.println(appointment.getDetails());
        }
    }
    public void addAppointment(Appointment appointment){
        appointments.addFirst(appointment);
    }
    public void removeAppointment(Appointment appointment){
        appointments.remove(appointment);
    }

    public LinkedList<Appointment> showAppointmentList(){
        for (int i=0;i<appointments.size();i++){
            System.out.println("["+(i+1)+"]"+appointments.get(i).getDetails());
        }
        return appointments;
    }
}
