package org.vladstasyshyn.exceptionhandling;

import java.time.LocalDateTime;

public class UserControllerExceptionResponse extends ControllerExceptionResponse {
    public UserControllerExceptionResponse(int status, String path, String exceptionName, String message, LocalDateTime timestamp) {
        super(status, path, exceptionName, message, timestamp);
    }
}
