package org.vladstasyshyn.logging.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vladstasyshyn.exceptionhandling.ControllerExceptionResponse;

@Component
@Slf4j
public class TraceLogger implements ApiLogger {
    @Override
    public void log(ControllerExceptionResponse response) {
        log.error("Handling: " + response.getExceptionName() + " Message: " + response.getMessage());
    }
}
