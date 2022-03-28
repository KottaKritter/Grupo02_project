package grupo02;

import lombok.Data;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

@Data
public class HandleAppointments implements Serializable, File {

    public static ArrayList<Appointment> listAppointments = new ArrayList<>();
    private static Logger logger = Logger.getLogger(ValidatePerson.class);

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
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        } catch (IOException e) {
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        } finally {
            try {
                fichero.close();
            } catch (IOException e) {
                logger.error("the file could not be closed", e);
                System.out.println("the file was not found");
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
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        } catch (IOException e) {
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        } catch (ClassNotFoundException e) {
            logger.error("file path not found", e);
            System.out.println("the file was not found");
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
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        } catch (IOException e) {
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        } catch (ClassNotFoundException e) {
            logger.error("file path not found", e);
            System.out.println("the file was not found");
        }
        return appointments;
    }

}
