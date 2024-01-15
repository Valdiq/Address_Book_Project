package org.vlad_stasyshyn.dao;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "contactType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Company.class, name = "COMPANY"),
        @JsonSubTypes.Type(value = Person.class, name = "PERSON")
})
public abstract class Contact {

    private ContactType contactType;

    private Long id;

    private String phoneNumber;

    private String email;

}
