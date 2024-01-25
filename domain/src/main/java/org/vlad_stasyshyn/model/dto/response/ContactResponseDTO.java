package org.vlad_stasyshyn.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vlad_stasyshyn.model.enums.ContactType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ContactResponseDTO {

    private Long id;

    private ContactType contactType;

    public abstract String displayName();
}
