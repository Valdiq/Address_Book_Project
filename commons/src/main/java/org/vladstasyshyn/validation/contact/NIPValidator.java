package org.vladstasyshyn.validation.contact;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NIPValidator implements ConstraintValidator<NIP, String> {

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return isValidNIP(string);
    }

    public boolean isValidNIP(String nip) {
        if (nip == null) {
            return true;
        } else {
            if (nip.length() != 10 || !nip.matches("^\\d+$")) {
                return false;
            }

            int[] weights = {6, 5, 7, 2, 3, 4, 5, 6, 7};
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                sum += Integer.parseInt(String.valueOf(nip.charAt(i))) * weights[i];
            }

            return Integer.parseInt(String.valueOf(nip.charAt(9))) == sum % 11;
        }
    }
}