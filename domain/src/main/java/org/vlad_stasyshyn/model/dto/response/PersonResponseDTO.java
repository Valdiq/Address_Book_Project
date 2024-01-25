package org.vlad_stasyshyn.model.dto.response;


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

    @Override
    public String displayName() {
        return firstName + " " + lastName;
    }
}
