package pl.sda.springtraining.web.validator;


import org.apache.logging.log4j.util.Strings;
import pl.sda.springtraining.domain.patient.Patient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameLengthValidator implements ConstraintValidator<NameLength, Patient> {
    @Override
    public boolean isValid(Patient patient, ConstraintValidatorContext context) {
        String nameAndSurname = patient.getName().concat(patient.getSurname());
        return nameAndSurname.length() > 50
                && Strings.isNotBlank(patient.getName())
                && Strings.isNotBlank(patient.getSurname());
    }
}
