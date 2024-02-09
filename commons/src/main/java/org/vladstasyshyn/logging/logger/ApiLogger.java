package org.vladstasyshyn.logging.logger;

import org.vladstasyshyn.exceptionhandling.ControllerExceptionResponse;

public interface ApiLogger {
    void log(ControllerExceptionResponse response);
}
