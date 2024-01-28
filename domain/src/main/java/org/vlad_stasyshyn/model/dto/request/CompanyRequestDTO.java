package org.vlad_stasyshyn.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeName(CompanyRequestDTO.COMPANY_JSON_TYPE_NAME)
public class CompanyRequestDTO extends ContactRequestDTO {
    public static final String COMPANY_JSON_TYPE_NAME = "COMPANY";

    @JsonProperty(required = true)
    @Length(max = 30)
    private String name;

    @JsonProperty(value = "NIP")
    @org.vlad_stasyshyn.validation.NIP
    private String NIP;

}
