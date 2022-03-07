package grupo02;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import static grupo02.FileManagement.readDoctors;

@Data
public class SpreadSheet implements Serializable {

    static ArrayList<Doctor> availableDoctors = new ArrayList();

    public static void addAvailableDoctors(Doctor doctor){
        availableDoctors.add(doctor);
    }

    public static Doctor getADoctor(){
        Random numero = new Random();
        int indice =  numero.nextInt(0,availableDoctors.size());
        return availableDoctors.get(indice);
    }

    public static ArrayList <Doctor> getDoctorsAvailable(){
        ArrayList<Doctor> doctors = readDoctors("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt");
        for (int i = 0; i < doctors.size(); i++) {
            availableDoctors.add(doctors.get(i));
        }
        return doctors;
    }

    @Override
    public String toString() {
        return availableDoctors.toString();

    }
}

