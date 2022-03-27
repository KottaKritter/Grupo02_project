package grupo02;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Patient extends Person{
    private final int patientCounter;
    private static int counter;
    private String id;
    private String age;
    private String weight;
    private String height;
    private String blood;

    public Patient(String name, String lastName, String phone, String email, String id, String age, String weight, String height, String blood){
        super(name, lastName, phone, email);
        this.patientCounter = ++counter;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.blood = blood;
    }

    public Patient(){
        this.patientCounter = ++counter;
    }

    @Override
    public String toString() {
        return "Patient: " + "\n" + super.toString()+
                "id: " + id +
                ", age: " + age +
                ", weight: " + weight +
                ", height: " + height +
                ", blood: " + blood + '.' + "\n";
    }
}
