package ui;

import java.util.Scanner;


public class UIMenu {


    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Who you are:?");

        int response = 0;
        do {
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Patient");
                    System.out.println("Accessing patients");
                    UIPatient.registerPatient();
                    break;
                case 2:
                    System.out.println("Doctor");
                    System.out.println("Accessing the database of doctors");
                    UIDoctor.showDoctorMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }






}
