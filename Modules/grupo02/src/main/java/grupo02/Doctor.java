package grupo02;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Doctor extends Person{
    private String specialty;

    public Doctor(String name, String lastName, long phone, String email, String specialty){
        super(name, lastName, phone, email);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() +
                "specialty='" + specialty + '\'' +
                '}';
    }
}
