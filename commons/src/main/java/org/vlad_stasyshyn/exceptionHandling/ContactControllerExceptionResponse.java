package org.vlad_stasyshyn.exceptionHandling;

import java.time.LocalDateTime;

public record ContactControllerExceptionResponse(int status, String path, String message, LocalDateTime timestamp) {
}
