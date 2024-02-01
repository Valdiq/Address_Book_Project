package org.vladstasyshyn.validation.contact;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PersonFullNameValidator implements ConstraintValidator<ValidPersonFullName, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^[a-zA-Z]+(?:[ ]?[a-zA-Z]+)*$") && s.length() <= 30;
    }
}
