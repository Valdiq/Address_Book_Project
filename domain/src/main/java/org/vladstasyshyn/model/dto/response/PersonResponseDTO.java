package org.vladstasyshyn.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class PersonResponseDTO extends ContactResponseDTO {

    private String firstName;

    private String lastName;

    private String PESEL;

}
