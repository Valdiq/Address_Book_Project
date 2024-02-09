package org.vladstasyshyn.exceptionhandling;

import java.time.LocalDateTime;

public class ContactControllerExceptionResponse extends ControllerExceptionResponse {
    public ContactControllerExceptionResponse(int status, String path, String exceptionName, String message, LocalDateTime timestamp) {
        super(status, path, exceptionName, message, timestamp);
    }
}
