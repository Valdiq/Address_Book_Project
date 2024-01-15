package org.vlad_stasyshyn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "person")
@DiscriminatorValue(PersonEntity.SUB_TYPE_DISCRIMINATOR)
@Data
@Accessors(chain = true)
public class PersonEntity extends ContactEntity {
    public static final String SUB_TYPE_DISCRIMINATOR = "PERSON";


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "pesel")
    private String PESEL;


}
