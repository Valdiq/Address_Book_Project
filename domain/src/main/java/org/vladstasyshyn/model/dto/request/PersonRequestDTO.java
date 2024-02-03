package org.vladstasyshyn.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeName(PersonRequestDTO.PERSON_JSON_TYPE_NAME)
public class PersonRequestDTO extends ContactRequestDTO {
    public static final String PERSON_JSON_TYPE_NAME = "PERSON";

    @JsonProperty(required = true)
    private String firstName;

    @JsonProperty(required = true)
    private String lastName;

    @JsonProperty(value = "PESEL")
    private String PESEL;

}
