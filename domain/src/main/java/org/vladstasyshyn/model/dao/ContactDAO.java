package org.vladstasyshyn.model.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.vladstasyshyn.model.enums.ContactType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public abstract class ContactDAO {

    private Long id;

    private ContactType contactType;

}
