package org.vladstasyshyn.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.vladstasyshyn.model.enums.ContactType;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "contactType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompanyRequestDTO.class, name = "COMPANY"),
        @JsonSubTypes.Type(value = PersonRequestDTO.class, name = "PERSON")
})
public abstract class ContactRequestDTO {

    @JsonProperty(required = true)
    private ContactType contactType;

    @JsonProperty(required = true)
    private String email;

    private String phone;

}
