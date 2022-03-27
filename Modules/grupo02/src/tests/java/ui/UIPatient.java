package ui;

import grupo02.Appointment;
import grupo02.HandleAppointments;
import grupo02.Patient;
import grupo02.ValidatePerson;

import java.util.Scanner;

import static grupo02.HandleAppointments.*;
import static grupo02.SpreadSheet.*;

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
                    if (readAppointments().isEmpty()){
                        System.out.println("There are no scheduled appointments");
                        System.out.println("I'm going to return you to the previous menu so you can schedule one.");
                        showPatientMenu(patient);
                        response = 0;
                        break;
                    }
                    System.out.println("This is your scheduled appointment: ");
                    System.out.println(getAppointmentById(patient.getPatientCounter()));
                    System.out.println("See you");
                    response = 0;
                    break;
                case 0:
                    System.out.println("I return you to the main menu");
                    UIMenu.showMenu();
                    response = 0;
                    break;
            }
        }while(response != 0);
    }

    public static void registerPatient(){
        ValidatePerson validatePerson = new ValidatePerson();
        Scanner sc = new Scanner(System.in);
        System.out.println("The first thing you need to do is to register here:");
        System.out.println("Tell me your name: ");
        String name = sc.nextLine();
        while(validatePerson.validateName(name) == false){
            System.out.println("Name Cannot be null or empty");
            System.out.println("Tell me your name: ");
            name = sc.nextLine();
        }
        System.out.println(("Tell me your lastname: "));
        String lastName = sc.nextLine();
        while(validatePerson.validateLastName(lastName) == false){
            System.out.println("Last name Cannot be null or empty");
            System.out.println(("Tell me your lastname: "));
            lastName = sc.nextLine();
        }
        System.out.println("What is you id number?: ");
        String id = sc.nextLine();
        while(validatePerson.validateId(id) == false){
            System.out.println("Id Cannot be null or empty and should contain only digits");
            System.out.println("What is your Id number?: ");
            id = sc.nextLine();
        }
        System.out.println("What is your thelephone number?: ");
        String phone = sc.nextLine();
        while(validatePerson.validatePhoneNumber(phone) == false){
            System.out.println("Phone Cannot be null or empty and should contain only digits");
            System.out.println("What is your thelephone number?: ");
            phone = sc.nextLine();
        }
        System.out.println("write your email: ");
        String email = sc.nextLine();
        while(validatePerson.validateEmail(email) == false){
            System.out.println("El email ingresado es inválido.");
            System.out.println("write your email: ");
            email = sc.nextLine();
        }
        System.out.println("write your age: ");
        String age = sc.nextLine();
        while(validatePerson.validateAge(age) == false){
            System.out.println("The age should contain only digits");
            System.out.println("write your age: ");
            age = sc.nextLine();
        }
        System.out.println("Write you weight: ");
        String weight = sc.nextLine();
        while(validatePerson.validateWeight(weight) == false){
            System.out.println("The weight should contain only digits");
            System.out.println("write your weight: ");
            weight = sc.nextLine();
        }
        System.out.println("Write your height: ");
        String height = sc.nextLine();
        while(validatePerson.validateHeight(height) == false){
            System.out.println("The height should contain only digits");
            System.out.println("write your height: ");
            height = sc.nextLine();
        }
        System.out.println("Write your blood type: ");
        String blood = sc.nextLine();
        Patient patient = new Patient(name,lastName,phone,email,id,age,weight,height,blood);
        showPatientMenu(patient);
    }

}
