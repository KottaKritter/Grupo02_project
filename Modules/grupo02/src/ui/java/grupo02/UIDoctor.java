package grupo02;


import java.util.Scanner;


import static grupo02.HandleAppointments.readAppointments;
import static grupo02.UIMenu.showMenu;

public class UIDoctor {


    public static void showDoctorMenu() {

        HandleAppointments handleAppointments = new HandleAppointments();
        SpreadSheet spreadSheet = new SpreadSheet();
        System.out.println("Welcome doctor");
        System.out.println("This is the list of appointments that we have at the moment ");
        if((readAppointments() == null)){
            System.out.println("No appointments scheduled yet");
            System.out.println("So you can take a break");
        }else{
            System.out.println(readAppointments());
        }

        int response = 0;
        do {
            System.out.println();
            System.out.println("What do you want to do now?: ");
            System.out.println("Write one option: ");
            System.out.println("1. Check the list of available doctors");
            System.out.println("2. return to the previous menu ");
            System.out.println("3. exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("showing the list of doctors ...");
                    spreadSheet.readFile();
                    System.out.println("I take you to the previous menu");
                    break;
                case 2:
                    System.out.println("returning to the main menu...");
                    showMenu();
                    break;

            }
        } while (response < 3);

    }
}
