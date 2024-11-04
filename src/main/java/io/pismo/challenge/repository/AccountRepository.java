package io.pismo.challenge.repository;

import io.pismo.challenge.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
