package org.vladstasyshyn.validation.contact;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PESELValidator implements ConstraintValidator<PESEL, String> {

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return isValidPESEL(string);
    }

    public boolean isValidPESEL(String pesel) {
        if (pesel == null) {
            return true;
        }
        if (pesel.length() != 11 || !pesel.matches("^\\d+$")) {
            return false;
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(String.valueOf(pesel.charAt(i))) * weights[i];
        }

        int checksum = (10 - (sum % 10)) % 10;

        return Integer.parseInt(String.valueOf(pesel.charAt(10))) == checksum;

    }
}
