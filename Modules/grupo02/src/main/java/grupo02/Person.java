package grupo02;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String lastName;
    private int phone;
    private String email;

    public Person(){

    }

    public Person(String name, String lastName, int phone, String email){
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
}
