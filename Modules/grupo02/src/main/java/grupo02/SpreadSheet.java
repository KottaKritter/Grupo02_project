package grupo02;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

@Data
public class SpreadSheet implements Serializable, File {

    static ArrayList<Doctor> availableDoctors = new ArrayList();

    public static Doctor getADoctor() {
        Random numero = new Random();
        int indice = numero.nextInt(0, availableDoctors.size());
        return availableDoctors.get(indice);
    }

    public static ArrayList<Doctor> getDoctorsAvailable() {
        ArrayList<Doctor> doctors = readDoctor("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt");
        for (int i = 0; i < doctors.size(); i++) {
            availableDoctors.add((Doctor) doctors.get(i));
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public String toString() {
        return availableDoctors.toString();

    }

    @Override
    public void saveFile() {
        FileOutputStream fichero = null;
        ArrayList<Doctor> doctors = getDoctorsAvailable();

        try {
            fichero = new FileOutputStream("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(doctors);
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
        ArrayList<Doctor> doctors = null;
        String fileName = "C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt";
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
        System.out.println(doctors);
        ;

    }
}

