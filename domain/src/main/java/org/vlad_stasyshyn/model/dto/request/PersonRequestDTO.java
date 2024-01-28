package org.vlad_stasyshyn.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.vlad_stasyshyn.validation.ValidPersonFullName;


@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeName(PersonRequestDTO.PERSON_JSON_TYPE_NAME)
public class PersonRequestDTO extends ContactRequestDTO {
    public static final String PERSON_JSON_TYPE_NAME = "PERSON";

    @JsonProperty(required = true)
    @ValidPersonFullName
    @Length(max = 30)
    private String firstName;

    @JsonProperty(required = true)
    @ValidPersonFullName
    @Length(max = 30)
    private String lastName;

    @JsonProperty(value = "PESEL")
    @org.vlad_stasyshyn.validation.PESEL
    private String PESEL;

}
