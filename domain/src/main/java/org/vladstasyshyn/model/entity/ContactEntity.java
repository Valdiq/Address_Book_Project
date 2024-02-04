package org.vladstasyshyn.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.vladstasyshyn.audit.AuditorEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "contact")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "contact_type", discriminatorType = DiscriminatorType.STRING)
@Data
@Accessors(chain = true)
public abstract class ContactEntity extends AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_seq")
    @SequenceGenerator(name = "contact_id_seq", sequenceName = "contact_id_seq", allocationSize = 10)
    private Long id;

    @OneToOne(mappedBy = "contactEntity", cascade = CascadeType.ALL)
    private ContactDetailsEntity contactDetails;

}
