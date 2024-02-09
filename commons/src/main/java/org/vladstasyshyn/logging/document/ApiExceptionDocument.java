package org.vladstasyshyn.logging.document;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("contact_controller_exception")
@Data
@Accessors(chain = true)
public class ApiExceptionDocument {

    @Id
    private String id;

    private int status;

    private String path;

    private String exceptionName;

    private String message;

    private LocalDateTime timestamp;
}
