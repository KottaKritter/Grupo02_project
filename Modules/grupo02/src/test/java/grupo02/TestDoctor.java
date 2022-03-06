package grupo02;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static grupo02.FileManagement.*;

public class TestDoctor {
    public static void main(String[] args) {
        //crear planilla para ingresar medicos
        SpreadSheet planilla1 = new SpreadSheet();
        Doctor doctor1 = new Doctor("Andres", "Rodriguez", 3165432345l, "andresr42@gmail.com", "pediatria");
        Doctor doctor2 = new Doctor("Felipe", "Hernandez", 3165432345l, "42@gmail.com", "odontologo");
        Doctor doctor3 = new Doctor("Mario", "Conrrado", 3165432345l, "andresr42@gmail.com", "pediatria");

        planilla1.addAvailableDoctors(doctor1);
        planilla1.addAvailableDoctors(doctor2);
        planilla1.addAvailableDoctors(doctor3);

        Patient paciente1 = new Patient("Ricardo", "mendez", 316456372, "andres@mail.com", 12345, 34, 72, 1.70, "A+" );
        Patient paciente2 = new Patient("Andres", "Hernandez", 312456732, "fff@gmail.com", 32123, 30, 80, 1.75, "0-");

        //crear cita, en el constructor de cita pide un doctor, y con el metodo getaDoctor returna el doctor
        Appointment appointment1 = new Appointment(paciente1, planilla1.getADoctor());
        Appointment appointment2 = new Appointment(paciente2, planilla1.getADoctor());

        //crear el manejador de citas
        HandleAppointments handleAppointments = new HandleAppointments();

        //agendar una cita
        handleAppointments.bookAnAppointment(appointment1);

        //añadir cita a la lista
        handleAppointments.addAppointment(appointment1);

        //System.out.println(handleAppointments.bookAnAppointment(appointment1));
        //System.out.println(handleAppointments.bookAnAppointment(appointment2));

        //Guardar cita en el archivo de texto
        appointmentForSave("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt",handleAppointments.getAllAppointments());

        //leer todas las citas guardadas
        //System.out.println(readAppointments("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt"));


        //Guardar doctores al archivo de texto
        doctorSaved("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt",planilla1.getAllDoctor());
        //System.out.println(handleAppointments.getAllAppointments());

        //leer los doctores en el archivo de texto
        System.out.println(readDoctors("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt"));












    }
}
