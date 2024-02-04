package org.vladstasyshyn.validation.contact;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Invalid Phone Number (should contain only numbers)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
