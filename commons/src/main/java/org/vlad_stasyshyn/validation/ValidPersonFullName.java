package org.vlad_stasyshyn.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = {PersonFullNameValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonFullName {
    String message() default "Invalid First Name Or Last Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
