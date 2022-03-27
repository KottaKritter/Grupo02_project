package test;


import grupo02.Patient;
import grupo02.ValidatePerson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class ValidatePersonTest {
    static ValidatePerson validator;
    static Patient patient;

    @BeforeAll
    public static void beforeClass() throws Exception {
        validator = new ValidatePerson();
        patient = new Patient();
    }

    @Test
    @DisplayName("Should not allow to receive null or empty names")
    public void validateName() {
        patient.setName("");
        assert(validator.validateName(patient.getName()) == false);
    }

    @Test
    @DisplayName("Should not allow to receive null or empty lastname")
    public void validateLastName() {
        patient.setLastName("");
        assert(validator.validateLastName(patient.getLastName()) == false);
    }

    @Test
    @DisplayName("Should not allow to receive null values, empty or letters")
    public void validatePhoneNumber() {
        patient.setPhone("");
        assert(validator.validatePhoneNumber(patient.getPhone()) == false);
        patient.setPhone(null);
        assert(validator.validatePhoneNumber(patient.getPhone()) == false);
        patient.setPhone("sdfgrje21");
        assert (validator.validatePhoneNumber(patient.getPhone()) == false);
        }

    @Test
    @DisplayName("Should not allow to receive wrong emails")
    public void validateEmail() {
        patient.setEmail("asdr345");
        assert(validator.validateEmail(patient.getEmail())== false);
    }

    @Test
    @DisplayName("Should not allow to receive letters")
    public void validateId() {
        patient.setId("gjfkd23");
        assert(validator.validateId(patient.getId()) == false);
    }

    @Test
    @DisplayName("Should not allow to receive letters or empty values")
    public void validateAge() {
        patient.setAge("");
        assert(validator.validateAge(patient.getAge()) == false);
        patient.setAge("ert3");
        assert (validator.validateAge(patient.getAge())== false);
    }

    @Test
    @DisplayName("Should not allow to receive letter or empty values")
    public void validateWeight() {
        patient.setWeight("");
        assert(validator.validateWeight(patient.getWeight()) == false);
        patient.setWeight("ert4");
        assert(validator.validateWeight(patient.getWeight()) == false);
    }

    @Test
    @DisplayName("Should not allow to receive letter or empty values")
    public void validateHeight() {
        patient.setHeight("");
        assert(validator.validateHeight(patient.getHeight()) == false);
        patient.setHeight("er45");
        assert (validator.validateHeight(patient.getHeight()) == false);
    }
}