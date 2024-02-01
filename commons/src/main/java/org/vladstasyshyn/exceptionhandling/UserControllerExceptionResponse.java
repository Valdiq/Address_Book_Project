package org.vladstasyshyn.exceptionhandling;

import java.time.LocalDateTime;

public record UserControllerExceptionResponse(int status, String path, String message, LocalDateTime timestamp) {
}
