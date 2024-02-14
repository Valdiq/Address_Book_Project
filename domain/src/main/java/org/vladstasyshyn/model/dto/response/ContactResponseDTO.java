package org.vladstasyshyn.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vladstasyshyn.model.enums.ContactType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ContactResponseDTO {

    private Long id;

    private ContactType contactType;

    private String email;

    private String phone;

}
