package Hospital;

import java.util.*;

public class Login {
    private HospitalManagementSystem hospitalManagementSystem;

    public Login() {
        hospitalManagementSystem = new HospitalManagementSystem();
    }

    public void loginMenu() {
        System.out.println("============== Login Page ==============");
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter your name:");
            String name = InputChecker.getAlphabeticString(in);
            Patient patient = hospitalManagementSystem.searchPatient(name);
            if (patient != null) {
                hospitalManagementSystem.setCurrentPatient(patient);
                System.out.println("============================");
                System.out.println("   Welcome " + patient.getName());
                System.out.println("============================");
                MainMenu menu = new MainMenu();
                menu.mainMenu(hospitalManagementSystem);
            } else {
                System.out.println("Patient not found");
            }
        }

    }
}
