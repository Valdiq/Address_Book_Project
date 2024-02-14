package org.vladstasyshyn.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Table(name = "contact_details")
@Data
@Accessors(chain = true)
public class ContactDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private String phone;


    @OneToOne
    @JoinColumn(name = "contact_entity_id", referencedColumnName = "id")
    private ContactEntity contactEntity;
}
