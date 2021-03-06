package grupo02;

import lombok.Data;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

@Data
public class SpreadSheet implements Serializable, File {

    public static ArrayList<Doctor> availableDoctors = new ArrayList();
    private static Logger logger = Logger.getLogger(ValidatePerson.class);

    public static Doctor getADoctor() {
        Random numero = new Random();
        int indice = numero.nextInt(0, availableDoctors.size());
        return availableDoctors.get(indice);
    }

    public static ArrayList<Doctor> getDoctorsAvailable() {
        ArrayList<Doctor> doctors = readDoctor("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt");
        for (int i = 0; i < doctors.size(); i++) {
            availableDoctors.add(doctors.get(i));
        }
        if (doctors == null){
            System.out.println("There aren´t doctors available right now");
        }
        return doctors;
    }

    public static ArrayList<Doctor> readDoctor(String fileName) {
        ArrayList<Doctor> doctors = null;
        try {
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(fileName));
            doctors = (ArrayList<Doctor>) leerFichero.readObject();
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
        return doctors;
    }


    @Override
    public void saveFile() {
        FileOutputStream fichero = null;
        ArrayList<Doctor> doctors = availableDoctors;

        try {
            fichero = new FileOutputStream("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(doctors);
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
                logger.error("file path not found", e);
                System.out.println("the file was not found");
            }
        }
    }

    @Override
    public  void readFile() {
        ArrayList<Doctor> doctors = null;
        String fileName = "C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt";
        try {
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(fileName));
            doctors = (ArrayList<Doctor>) leerFichero.readObject();
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
        System.out.println(doctors);


    }
    @Override
    public String toString() {
        return availableDoctors.toString();

    }
}

