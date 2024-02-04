package org.vladstasyshyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vladstasyshyn.model.entity.ContactDetailsEntity;

import java.util.Optional;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity, Long> {
    Optional<ContactDetailsEntity> findByContactEntityId(Long id);
}
