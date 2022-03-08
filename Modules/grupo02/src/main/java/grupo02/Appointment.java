package grupo02;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Appointment implements Serializable {
    private final int id;
    private static int appointmentCounter;
    private final Timestamp date;
    private Patient patient;
    private Doctor availableDoctor;

    public Appointment(Patient patient, Doctor availableDoctor) {
        id = ++Appointment.appointmentCounter;
        this.patient = patient;
        this.availableDoctor = availableDoctor;
        long rangeBegin = Timestamp.valueOf("2022-03-08 00:00:00").getTime();
        long rangeEnd = Timestamp.valueOf("2022-04-08 00:58:00").getTime();
        long diff = rangeEnd - rangeBegin + 1;
        this.date = new Timestamp(rangeBegin + (long) (Math.random() * diff));
    }

    @Override
    public String toString() {
        return "Appointment: " + "\n" +
                "id: " + this.getId() + "\n" +
                "Patient: " + this.patient.getName() + " " + this.patient.getLastName() + "\n" +
                "Date: " + this.getDate().toString() + "\n" +
                 this.availableDoctor.toString() + "." + "\n";
    }
}












