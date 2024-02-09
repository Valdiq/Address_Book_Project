package org.vladstasyshyn.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public abstract class ControllerExceptionResponse {
    int status;
    String path;
    String exceptionName;
    String message;
    LocalDateTime timestamp;
}
