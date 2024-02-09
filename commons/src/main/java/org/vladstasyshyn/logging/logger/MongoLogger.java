package org.vladstasyshyn.logging.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vladstasyshyn.exceptionhandling.ControllerExceptionResponse;
import org.vladstasyshyn.logging.document.ApiExceptionDocument;
import org.vladstasyshyn.logging.repository.ApiExceptionRepository;


@Component
public class MongoLogger implements ApiLogger {

    @Autowired
    private ApiExceptionRepository repository;

    @Override
    public void log(ControllerExceptionResponse response) {
        ApiExceptionDocument document = new ApiExceptionDocument()
                .setPath(response.getPath())
                .setExceptionName(response.getExceptionName())
                .setStatus(response.getStatus())
                .setTimestamp(response.getTimestamp())
                .setMessage(response.getMessage());
        repository.insert(document);
    }
}
