package org.vlad_stasyshyn.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "contact")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "contact_type", discriminatorType = DiscriminatorType.STRING)
@Data
@Accessors(chain = true)
public abstract class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_seq")
    @SequenceGenerator(name = "contact_id_seq", sequenceName = "contact_id_seq", allocationSize = 10)
    private Long id;

}
