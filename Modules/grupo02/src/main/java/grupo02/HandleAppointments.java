package grupo02;

import lombok.Data;


import java.util.ArrayList;

@Data
public class HandleAppointments {

    private ArrayList<Appointment> appointments = new ArrayList();

    public HandleAppointments(){

    }


    public String  bookAnAppointment(Appointment appointment) {
        addAppointment(appointment);
        return "your assigned doctor is: "+ appointment.getAvailableDoctor().getName() + " " + appointment.getAvailableDoctor().getLastName() +
                " in the date "+ appointment.getDate().toString();
    }


    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }

    public  ArrayList<Appointment> getAllAppointments(){
        return appointments;
    }


}
