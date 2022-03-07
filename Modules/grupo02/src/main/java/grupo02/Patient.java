package grupo02;

import lombok.Data;

@Data
public class Patient extends Person{
    private final int patientCounter;
    private static int counter;
    private long id;
    private int age;
    private double weight;
    private double height;
    private String blood;

    public Patient(String name, String lastName, long phone, String email, long id, int age, double weight, double height, String blood){
        super(name, lastName, phone, email);
        this.patientCounter = ++counter;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.blood = blood;
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
