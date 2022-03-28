package grupo02;

import lombok.Data;
import java.io.Serializable;

@Data
public class Doctor extends Person implements Serializable {
    private String specialty;

    public Doctor(String name, String lastName, String phone, String email, String specialty){
        super(name, lastName, phone, email);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor: "  + super.toString() +
                "specialty: " + specialty + '.' + "\n";
    }
}
