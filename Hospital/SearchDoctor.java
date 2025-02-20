package Hospital;
import java.util.*;

public class SearchDoctor {
    public static void searchDoctorMenu(HospitalManagementSystem hospitalManagementSystem) {
        System.out.println("============== Search for a Doctor ==============");
        System.out.println( "Type the name of the doctor: ");
        Scanner input = new Scanner(System.in);
        String name = InputChecker.getAlphabeticString(input);
        Doctor doctor = hospitalManagementSystem.searchDoctor(name);
        if(doctor!=null){
            System.out.println(doctor.getDetails());
        }
        else{
            System.out.println("Doctor not found");
        }
    }
}
