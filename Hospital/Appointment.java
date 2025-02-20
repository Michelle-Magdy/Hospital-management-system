package Hospital;

public class Appointment {
    private String dateTime;
    private Doctor doctor;
    private Patient patient;
    public Appointment(String dateTime, Doctor doctor, Patient patient) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
    }
    public Appointment(String dateTime, Doctor doctor) {
        this.dateTime = dateTime;
        this.doctor = doctor;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public String getDetails(){
        return "Date and time: " + dateTime +"\n"+"Doctor: " + doctor.getName() +"\n";
    }
    public String getDetails(Patient patient){
        return "Date and time: " + dateTime +"\n"+"Doctor: " + doctor.getName() +"\n"+"Patient: " + patient.getName() +"\n";
    }
}
