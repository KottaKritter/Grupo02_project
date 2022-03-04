package grupo02;

import lombok.Data;
import java.sql.Timestamp;
import java.util.ArrayList;


@Data
public class Appointment {
    private final int id;
    private Patient patient;
    private Timestamp date;
    private Doctor availableDoctor;
    private static int AppointmentCounter;


    public Appointment(Patient patient, Doctor availableDoctor) {
        id = ++Appointment.AppointmentCounter;
        this.patient = patient;
        this.availableDoctor = availableDoctor;
    }

    public String bookAnAppointment() {

        long rangebegin = Timestamp.valueOf("2022-03-08 00:00:00").getTime();
        long rangeend = Timestamp.valueOf("2022-04-08 00:58:00").getTime();
        long diff = rangeend - rangebegin + 1;
        date = new Timestamp(rangebegin + (long) (Math.random() * diff));
        return "Su medico asignado es: "+ availableDoctor.getName()  + " "+ date.toString();
    }

    public String getYourAppointment(){
        return "Appointment: " + this.getId() + " ,patient: " + this.getPatient() + " Doctor: " + this.getAvailableDoctor() + " fecha: " +this.date.toString();
    }

    static ArrayList<String> appointments = new ArrayList();

    public void addAppointment(){
        appointments.add(getYourAppointment());
    }

    public static ArrayList<String> getAllAppointments(){
        return appointments;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", date=" + date +
                ", availableDoctor=" + availableDoctor +
                '}';
    }
}












