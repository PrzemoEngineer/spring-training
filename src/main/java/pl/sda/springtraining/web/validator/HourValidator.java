package pl.sda.springtraining.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HourValidator implements ConstraintValidator<Hour, Integer> {
    @Override
    public void initialize(Hour constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value >= 0 && value <= 23) {
            return true;
        }
        return false;
    }
}
