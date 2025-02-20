package Hospital;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {
    private static final String[] options = {"Search for a doctor", "Book an appointment", "Cancel an appointment", "Show my appointments", "log out", "Exit"};

    private enum MenuOptions {SEARCH_DOCTOR, BOOK_APPOINTMENT, CANCEL_APPOINTMENT, SHOW_APPOINTMENTS, LOG_OUT, EXIT}

    ;
    private static MenuOptions option;

    private static void showOptions() {
        System.out.println("============== Main Menu ==============");
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i + 1) + "] " + options[i]);
        }
    }

    public static void mainMenu(HospitalManagementSystem hospitalManagementSystem) {
        while (true) {
            showOptions();
            int choice = InputChecker.getIntegerBetween(1, options.length);
            option = MenuOptions.values()[choice - 1];

            switch (option) {
                case SEARCH_DOCTOR:
                    SearchDoctor.searchDoctorMenu(hospitalManagementSystem);
                    break;
                case BOOK_APPOINTMENT:
                    BookAppointment.bookAppointmentMenu(hospitalManagementSystem);
                    break;
                case CANCEL_APPOINTMENT:
                    CancelAppointment.cancelAppointment(hospitalManagementSystem);
                    break;
                case SHOW_APPOINTMENTS:
                    hospitalManagementSystem.getCurrentPatient().showAppointmentList();
                    break;
                case LOG_OUT:
                    System.out.println("You have logged out");
                    return;
                case EXIT:
                    System.exit(0);
                    break;
            }

        }

    }

}
