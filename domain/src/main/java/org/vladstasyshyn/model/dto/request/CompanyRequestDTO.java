package org.vladstasyshyn.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeName(CompanyRequestDTO.COMPANY_JSON_TYPE_NAME)
public class CompanyRequestDTO extends ContactRequestDTO {
    public static final String COMPANY_JSON_TYPE_NAME = "COMPANY";

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(value = "NIP")
    private String NIP;

}
