package grupo02;

import org.apache.log4j.Logger;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePerson {

    private static Logger logger = Logger.getLogger(ValidatePerson.class);

    public boolean validateName(String name) {
        if (name == null || name.isEmpty() ) {
            logger.warn("the received name is null or empty");
            return false;
        }else{
            return true;
        }
    }

    public boolean validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            logger.warn("the received lastname is null or empty");
            return false;
        }else{
            return true;
        }
    }

    public boolean validatePhoneNumber(String phone) {
        if (phone == null || phone.isEmpty()) {
            logger.warn("the received phone is null or empty");
            return false;
        }
        try {
            Long.parseLong(phone);
            return true;
        } catch (NumberFormatException ex) {
            logger.warn("letters were found in the entered data");
            return false;
        }
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == false) {
            logger.warn("the received email is null");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validateId(String id){
        try {
            Integer.parseInt(id);
            return true;
        } catch (NumberFormatException ex){
            logger.warn("the received id is null", ex);
            return false;
        }
    }

    public boolean validateAge(String age){
        try {
            Integer.parseInt(age);
            return true;
        } catch (NumberFormatException ex){
            logger.warn("the received age is null", ex);
            return false;
        }
    }

    public boolean validateWeight(String weight){
        try {
            Integer.parseInt(weight);
            return true;
        } catch (NumberFormatException ex){
            logger.warn("the received weight is null", ex);
            return false;
        }
    }

    public boolean validateHeight(String height){
        try {
            Float.parseFloat(height);
            return true;
        } catch (NumberFormatException ex){
            logger.warn("the received height is null", ex);
            return false;
        }
    }
}
