package org.vladstasyshyn.model.dao;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.vladstasyshyn.validation.contact.ValidPersonFullName;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PersonDAO extends ContactDAO {

    @NotBlank
    @ValidPersonFullName
    @Length(max = 30)
    private String firstName;

    @NotBlank
    @ValidPersonFullName
    @Length(max = 30)
    private String lastName;

    @org.vladstasyshyn.validation.contact.PESEL
    private String PESEL;

}
