package org.vladstasyshyn.validation.contact;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return isValidPhone(string);
    }

    public boolean isValidPhone(String phone) {
        if (phone == null) {
            return true;
        }
        return phone.matches("^[+]?[0-9]{5,15}$");
    }
}
