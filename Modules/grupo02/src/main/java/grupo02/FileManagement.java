package grupo02;

import lombok.Data;

import java.io.*;

@Data
public class FileManagement {
    private SpreadSheet spreadSheet;
    private Appointment appointment;
    private Diagnosis diagnosis;
    private File doctorsFile;
    private File appointmenstFile;
    private File diagnosisFile;

    public FileManagement(){

    }

    public void doctorsSaved(String fileName, String content){
        File doctorFile = new File(fileName);
        try{
            PrintWriter out = new PrintWriter(doctorFile);
            out.println(content);
            out.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void appointmentsSaved(String fileName, String content){
        File appointmentsFile = new File(fileName);
        try{
            PrintWriter out = new PrintWriter(appointmentsFile);
            out.println(content);
            out.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void diagnosisSaved(String fileName, String content){
        File diagnosisFile = new File(fileName);
        try{
            PrintWriter out = new PrintWriter(diagnosisFile);
            out.println(content);
            out.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


}
