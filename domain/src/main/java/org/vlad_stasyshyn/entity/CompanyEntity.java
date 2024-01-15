package org.vlad_stasyshyn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "company")
@DiscriminatorValue(CompanyEntity.SUB_TYPE_DISCRIMINATOR)
@Data
@Accessors(chain = true)
public class CompanyEntity extends ContactEntity {
    public static final String SUB_TYPE_DISCRIMINATOR = "COMPANY";


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "nip", nullable = false)
    private String NIP;

}
