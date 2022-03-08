package grupo02;

import java.util.Scanner;

import static grupo02.HandleAppointments.*;
import static grupo02.SpreadSheet.*;
import static grupo02.UIMenu.*;

public class UIPatient {

    public static void showPatientMenu(Patient patient) {
        HandleAppointments handleAppointments = new HandleAppointments();
        int response = 0;
        do {
            System.out.println("Welcome " + patient.getName());
            System.out.println("What do you want to do?: ");
            System.out.println("Write one option: ");
            System.out.println("1. Book an appointment");
            System.out.println("2. print my appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Booking an appointment::");
                    getDoctorsAvailable();
                    Appointment appointment = new Appointment(patient, getADoctor());
                    addAppointment(appointment);
                    System.out.println(bookAnAppointment(appointment));
                    handleAppointments.saveFile();
                    System.out.println("I return you to the previous page...");
                    showPatientMenu(patient);
                    break;
                case 2:
                    if (readAppointments("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt").isEmpty()){
                        System.out.println("There are no scheduled appointments");
                        System.out.println("I'm going to return you to the previous menu so you can schedule one.");
                        showPatientMenu(patient);
                        response = 0;
                        break;
                    }
                    System.out.println("This is your scheduled appointment: ");
                    handleAppointments.readFile();
                    System.out.println(getAppointmentById(patient.getPatientCounter()));
                    System.out.println("See you");
                    response = 0;
                    break;
                case 0:
                    System.out.println("I return you to the main menu");
                    showMenu();
                    response = 0;
                    break;
            }
        }while(response != 0);
    }

    public static void registerPatient(){
        Scanner sc = new Scanner(System.in);
        System.out.println("The first thing you need to do is to register here:");
        System.out.println("Tell me your name: ");
        String name = sc.nextLine();
        System.out.println(("Tell me your lastname: "));
        String lastName = sc.nextLine();
        System.out.println("What is you id number?: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("What is your thelephone number?: ");
        long phone = sc.nextLong();
        sc.nextLine();
        System.out.println("write your email: ");
        String email = sc.nextLine();
        System.out.println("write your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Write you weight: ");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Write your height: ");
        double height = sc.nextDouble();
        sc.nextLine();
        System.out.println("Write your blood type: ");
        String blood = sc.nextLine();
        Patient patient = new Patient(name,lastName,phone,email,id,age,weight,height,blood);
        showPatientMenu(patient);
    }

}
