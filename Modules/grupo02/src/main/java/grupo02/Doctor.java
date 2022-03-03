package grupo02;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Doctor extends Person{
    private String specialty;

    public Doctor(String name, String lastName, int phone, String email, String specialty){
        super(name, lastName, phone, email);
        this.specialty = specialty;
    }

    ArrayList<Doctor> availableDoctors = new ArrayList();

    public void addAvailableDoctors(Doctor doctor){
        availableDoctors.add(doctor);
    }

    public ArrayList<Doctor> getAllDoctor(){
        return availableDoctors;
    }
}
