package grupo02;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;

@Data
public class HandleAppointments implements Serializable, File {

    public static ArrayList<Appointment> listAppointments = new ArrayList<>();

    public HandleAppointments() {

    }

    public static String bookAnAppointment(Appointment appointment){
        return "your assigned doctor is: " + appointment.getAvailableDoctor().getName() + " " + appointment.getAvailableDoctor().getLastName() +
                " in the date " + appointment.getDate().toString();
    }

    public static Appointment getAppointmentById(int id) {
        return listAppointments.get(id -1);
    }

    public static void addAppointment(Appointment appointment) {
        listAppointments.add(appointment);
    }

    public static ArrayList<Appointment> saveAppointments() {
        return listAppointments;
    }

    public void saveFile() {
        FileOutputStream fichero = null;
        ArrayList<Appointment> appointments = saveAppointments();

        try {
            fichero = new FileOutputStream("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(appointments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void readFile() {
        ArrayList<Appointment> appointments = null;
        String fileName = "C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt";

        try {
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(fileName));
            appointments = (ArrayList<Appointment>) leerFichero.readObject();
            leerFichero.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(appointments);

    }

    public static ArrayList<Appointment> readAppointments() {
        ArrayList<Appointment> appointments = null;
        String fileName = "C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt";
        try {
            ObjectInputStream leerCitas = new ObjectInputStream(new FileInputStream(fileName));
            appointments = (ArrayList<Appointment>) leerCitas.readObject();
            leerCitas.close();

        } catch (FileNotFoundException e) {
            System.out.println("We did not find the file");
        } catch (IOException e) {
            System.out.println("the list is empty");
        } catch (ClassNotFoundException e) {
            System.out.println("We did not find the file");
        }
        return appointments;
    }

}
