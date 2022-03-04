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
        //echa = Calendar.getInstance().getTime()
        //System.out.println(fecha);

        Patient paciente1 = new Patient("Ricardo", "mendez", 316456372, "andres@mail.com", 12345, 34, 72, 1.70, "A+" );


        long rangebegin = Timestamp.valueOf("2013-02-08 00:00:00").getTime();
        long rangeend = Timestamp.valueOf("2013-02-08 00:58:00").getTime();
        long diff = rangeend - rangebegin + 1;
        Timestamp rand = new Timestamp(rangebegin + (long)(Math.random() * diff));
        //System.out.println("rand = " + rand);

        Appointment cita1 = new Appointment(paciente1,planilla1.getADoctor());
        cita1.bookAnAppointment(rand);
        Appointment cita2 = new Appointment(paciente1, planilla1.getADoctor());

        System.out.println("cita = " + cita1.getAnAppointment());
        System.out.println("cita2  = " + cita2.getAnAppointment() );

        









    }
}
