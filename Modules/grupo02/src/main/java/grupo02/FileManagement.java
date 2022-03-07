package grupo02;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;

@Data
public class FileManagement implements Serializable {
    private SpreadSheet spreadSheet;
    private Appointment appointment;
    private File doctorsFile;
    private File diagnosisFile;

    public FileManagement(){

    }

    public static void doctorSaved(String fileName, ArrayList<Doctor> doctor){
        FileOutputStream fichero = null;

        try {
            fichero = new FileOutputStream(fileName);
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(doctor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fichero.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void appointmentForSave(String fileName, ArrayList<Appointment> appointments){
        FileOutputStream fichero = null;

        try {
            fichero = new FileOutputStream(fileName);
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(appointments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fichero.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static ArrayList<Doctor> readDoctors(String fileName) {
        ArrayList<Doctor> doctors = null;
        try {
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(fileName));
            doctors = (ArrayList<Doctor>) leerFichero.readObject();
            leerFichero.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static ArrayList<Appointment> readAppointments(String fileName){
        ArrayList<Appointment> appointments = null;
        try {
            ObjectInputStream leerCitas = new ObjectInputStream(new FileInputStream(fileName));
            appointments = (ArrayList<Appointment>) leerCitas.readObject();
            leerCitas.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return appointments;
    }





}
