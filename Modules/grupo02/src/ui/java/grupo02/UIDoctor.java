package grupo02;


import java.util.Scanner;

import static grupo02.FileManagement.*;
import static grupo02.UIMenu.showMenu;

public class UIDoctor {

    public static void showDoctorMenu() {

        System.out.println("Welcome doctor");
        System.out.println("This is the list of appointments that we have at the moment ");
        System.out.println(readAppointments("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt"));

        int response = 0;
        do {
            System.out.println("What do you want to do now?: ");
            System.out.println("Write one option: ");
            System.out.println("1. return to the previous menu ");
            System.out.println("2. exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("returning to the main menu...");
                    showMenu();
                    break;
                case 2:
                    System.out.println("Bye ...");
                    break;

            }

        } while (response == 2);

    }
}
