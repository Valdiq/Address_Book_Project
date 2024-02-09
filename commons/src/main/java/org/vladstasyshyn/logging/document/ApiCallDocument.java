package org.vladstasyshyn.logging.document;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("api_call")
@Data
@Accessors(chain = true)
public class ApiCallDocument {

    @Id
    private String id;

    private String methodName;

    private String className;

    private LocalDateTime executionTimestamp;

    private long executionTimeMs;
}
