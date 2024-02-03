package org.vladstasyshyn.exceptionhandling;

import java.time.LocalDateTime;

public record ContactControllerExceptionResponse(int status, String path, String message, LocalDateTime timestamp) {
}
