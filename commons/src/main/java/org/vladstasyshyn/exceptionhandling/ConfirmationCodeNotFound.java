package org.vladstasyshyn.exceptionhandling;

public class ConfirmationCodeNotFound extends RuntimeException {
    public ConfirmationCodeNotFound() {
        super("Confirmation Code Not Found");
    }
}
