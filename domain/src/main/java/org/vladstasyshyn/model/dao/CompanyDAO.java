package org.vladstasyshyn.model.dao;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CompanyDAO extends ContactDAO {

    @NotBlank
    @Length(max = 30)
    private String name;

    @org.vladstasyshyn.validation.contact.NIP
    private String NIP;

    @Override
    public String getFullName() {
        return name;
    }
}
