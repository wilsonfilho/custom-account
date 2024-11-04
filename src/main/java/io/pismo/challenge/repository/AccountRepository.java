package io.pismo.challenge.repository;

import io.pismo.challenge.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByDocumentNumber(String documentNumber);
}
