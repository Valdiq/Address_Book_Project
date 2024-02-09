package org.vladstasyshyn.logging.util;

import lombok.extern.slf4j.Slf4j;
import org.vladstasyshyn.exceptionhandling.ControllerExceptionResponse;
import org.vladstasyshyn.logging.logger.ApiLogger;

import java.util.List;
import java.util.Map;

@Slf4j
public class LogExceptionHandlerUtil {
    public static void logError(ControllerExceptionResponse response, List<String> loggersName, Map<String, ApiLogger> apiLoggerMap) {
        if (loggersName.isEmpty()) {
            log.error("API Logger Implementation Not Found");
            return;
        }
        for (String loggerName : loggersName) {
            ApiLogger logger = apiLoggerMap.get(loggerName);
            if (logger != null) {
                logger.log(response);
            } else {
                log.error("API Logger Implementation Not Found");
            }
        }
    }
}
