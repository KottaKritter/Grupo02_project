package grupo02;

import lombok.Data;
import java.io.Serializable;

@Data
public class Person implements Serializable {
    private String name;
    private String lastName;
    private String phone;
    private String email;

    public Person(){

    }

    public Person(String name, String lastName, String phone, String email){
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }


    @Override
    public String toString() {
        return "name: " + name + " lastName=: " + lastName + ", phone: " + phone +
                " email: "  + email + "." + "\n";
    }
}
