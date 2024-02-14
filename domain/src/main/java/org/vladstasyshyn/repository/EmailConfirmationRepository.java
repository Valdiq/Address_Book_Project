package org.vladstasyshyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vladstasyshyn.model.entity.EmailConfirmationEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailConfirmationRepository extends JpaRepository<EmailConfirmationEntity, String> {
    Optional<EmailConfirmationEntity> findByContactDetailsId(Long id);

    List<EmailConfirmationEntity> findAllBySent(boolean sent);
}
