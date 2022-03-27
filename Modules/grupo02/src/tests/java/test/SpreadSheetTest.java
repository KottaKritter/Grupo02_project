package test;

import grupo02.Doctor;
import grupo02.SpreadSheet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SpreadSheetTest {

    @Test
    public  void getADoctor() {
        getDoctorsAvailable();
        Doctor doctorTest = SpreadSheet.getADoctor();
        assertTrue(doctorTest != null);

    }

    @Test
    public void getDoctorsAvailable() {
        ArrayList<Doctor> doctors = SpreadSheet.getDoctorsAvailable();
        assertTrue(doctors != null);

    }
}