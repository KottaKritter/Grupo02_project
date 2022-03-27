package grupo02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePerson {

    public boolean validateName(String name) {
        if (name == null || name.isEmpty() ) {
            return false;
        }else{
            return true;
        }
    }

    public boolean validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            return false;
        }else{
            return true;
        }
    }

    public boolean validatePhoneNumber(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        try {
            Long.parseLong(phone);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == false) {
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
            return false;
        }
    }

    public boolean validateAge(String age){
        try {
            Integer.parseInt(age);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public boolean validateWeight(String weight){
        try {
            Integer.parseInt(weight);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public boolean validateHeight(String height){
        try {
            Float.parseFloat(height);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
