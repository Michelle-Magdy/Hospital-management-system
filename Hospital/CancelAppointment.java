package Hospital;
import java.util.LinkedList;

public class CancelAppointment {
    public static void cancelAppointment(HospitalManagementSystem hospitalManagementSystem){
        System.out.println("============== Cancel appointment ==============");
        LinkedList<Appointment> appointments = hospitalManagementSystem.getCurrentPatient().showAppointmentList();
        System.out.println("Choose the appointment to cancel:");
        int appointmentIndex = InputChecker.getIntegerBetween(1,appointments.size());
        hospitalManagementSystem.CancelAppointment(appointments.get(appointmentIndex-1));
        System.out.println("Appointment cancelled!");
    }
}
