package test;

import grupo02.Appointment;
import grupo02.HandleAppointments;
import grupo02.Patient;
import grupo02.SpreadSheet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static grupo02.SpreadSheet.getDoctorsAvailable;
import static org.junit.jupiter.api.Assertions.*;


public class HandleAppointmentsTest {
    static Appointment appointment;
    static Patient patient;

    @BeforeAll
    public static void beforeClass() throws Exception {
        patient = new Patient("Rodrigo", "cardenas", "317654322", "rodri@mail.com", "1234", "24","68", "1.70", "o-" );
        getDoctorsAvailable();
        appointment = new Appointment(patient, SpreadSheet.getADoctor());
        HandleAppointments.addAppointment(appointment);
    }

    @Test
    public void bookAnAppointment() {
        String newAppointment = HandleAppointments.bookAnAppointment(appointment);
        assertFalse(newAppointment.isEmpty());
    }

    @Test
    public void getAppointmentById() {
        HandleAppointments.addAppointment(appointment);
        Appointment appointmentBooked = HandleAppointments.getAppointmentById(patient.getPatientCounter());
        assertTrue(appointment == appointmentBooked);
    }

    @Test
    public void addAppointment(){
        HandleAppointments.addAppointment(appointment);
        assertTrue(appointment == HandleAppointments.getAppointmentById(appointment.getId()));
    }

    @Test
    public void saveAppointments(){
        ArrayList<Appointment> appointments = HandleAppointments.saveAppointments();
        assertFalse(appointments.isEmpty());
    }
}