package org.vladstasyshyn.model.dao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.vladstasyshyn.model.enums.ContactType;
import org.vladstasyshyn.validation.contact.Phone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public abstract class ContactDAO {

    private Long id;

    private ContactType contactType;

    @Email
    @NotBlank
    private String email;

    @Phone
    private String phone;

    public abstract String getFullName();
}
