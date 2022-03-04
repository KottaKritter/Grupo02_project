package grupo02;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestDoctor {
    public static void main(String[] args) {
        SpreadSheet planilla1 = new SpreadSheet();
        Doctor doctor1 = new Doctor("Andres", "Rodriguez", 3165432345l, "andresr42@gmail.com", "pediatria");
        Doctor doctor2 = new Doctor("Felipe", "Hernandez", 3165432345l, "andresr42@gmail.com", "pediatria");
        Doctor doctor3 = new Doctor("Mario", "Conrrado", 3165432345l, "andresr42@gmail.com", "pediatria");

        planilla1.addAvailableDoctors(doctor1);
        planilla1.addAvailableDoctors(doctor2);
        planilla1.addAvailableDoctors(doctor3);
        //System.out.print(planilla1.getAllDoctor().toString());
        //SpreadSheet doctor = planilla1.getADoctor();


        Patient paciente1 = new Patient("Ricardo", "mendez", 316456372, "andres@mail.com", 12345, 34, 72, 1.70, "A+" );

        Appointment cita1 = new Appointment(paciente1,planilla1.getADoctor());
        cita1.bookAnAppointment();
        Appointment cita2 = new Appointment(paciente1, planilla1.getADoctor());
        cita2.bookAnAppointment();
        cita1.addAppointment();
        cita2.addAppointment();

        System.out.println("cita = " + cita1.getYourAppointment());
        System.out.println("cita2  = " + cita2.getYourAppointment() );

        FileManagement file1 = new FileManagement();
        //file1.doctorsSaved("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\doctors.txt",planilla1.getAllDoctor().toString());
        //file1.appointmentsSaved("C:\\Users\\Andres F\\Proyecto-Kodigo\\Grupo02_project\\Modules\\grupo02\\src\\main\\java\\grupo02\\Files\\appointments.txt",Appointment.getAllAppointments().toString());
        //file1.

        









    }
}
