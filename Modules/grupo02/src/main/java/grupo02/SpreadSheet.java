package grupo02;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

@Data
public class SpreadSheet implements Serializable {

    ArrayList<Doctor> availableDoctors = new ArrayList();


    public void addAvailableDoctors(Doctor doctor){
        availableDoctors.add(doctor);
    }

    public ArrayList<Doctor> getAllDoctor(){
        return availableDoctors;
    }

    public Doctor getADoctor(){
        Random numero = new Random();
        int indice =  numero.nextInt(0,availableDoctors.size());
        return availableDoctors.get(indice);
    }

    @Override
    public String toString() {
        return availableDoctors.toString();

    }
}

