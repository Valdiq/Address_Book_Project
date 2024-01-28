package org.vlad_stasyshyn.exceptionHandling;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(Long id) {
        super("Contact With ID: " + id + " Not Found");
    }

    public ContactNotFoundException() {
        super("No Contacts Found");
    }

    @Override
    public String getMessage() {
        return "Contact Not Found";
    }
}
