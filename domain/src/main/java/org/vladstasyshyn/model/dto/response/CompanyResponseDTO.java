package org.vladstasyshyn.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CompanyResponseDTO extends ContactResponseDTO {

    private String name;

    private String NIP;

    @Override
    public String displayName() {
        return name;
    }
}
