package org.vladstasyshyn.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class EmailConfirmationEntity {

    @Id
    @Column(updatable = false)
    private String code;

    @Column(nullable = false)
    private boolean sent;

    @Column(nullable = false)
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "contact_details_id", nullable = false)
    private ContactDetailsEntity contactDetails;

}
