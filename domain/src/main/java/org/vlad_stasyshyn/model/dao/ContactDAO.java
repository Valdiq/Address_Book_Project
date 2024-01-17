package org.vlad_stasyshyn.model.dao;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.vlad_stasyshyn.model.enums.ContactType;

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
        @JsonSubTypes.Type(value = CompanyDAO.class, name = "COMPANY"),
        @JsonSubTypes.Type(value = PersonDAO.class, name = "PERSON")
})
public abstract class ContactDAO {

    private ContactType contactType;

    private Long id;

}
