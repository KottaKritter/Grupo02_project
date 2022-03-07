package grupo02;

import lombok.Data;


import java.util.ArrayList;

import static grupo02.FileManagement.readAppointments;

@Data
public class HandleAppointments {

    private static ArrayList<Appointment> listAppointments = new ArrayList();

    public HandleAppointments(){

    }

    public static String  bookAnAppointment(Appointment appointment) {
        addAppointment(appointment);
        return "your assigned doctor is: "+ appointment.getAvailableDoctor().getName() + " " + appointment.getAvailableDoctor().getLastName() +
                " in the date "+ appointment.getDate().toString();
    }

    public static ArrayList <Appointment> getAppointments(){
        ArrayList<Appointment> appointments = readAppointments("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt");
        for (int i = 0; i < appointments.size(); i++) {
            listAppointments.add(appointments.get(i));
        }
        return appointments;
    }

    public static Appointment getAppointmentById(int id){
        return listAppointments.get(id);
    }

    public static void addAppointment(Appointment appointment){
        listAppointments.add(appointment);
    }

    public  static ArrayList <Appointment> saveAppointments(){
        return listAppointments;
    }



}
