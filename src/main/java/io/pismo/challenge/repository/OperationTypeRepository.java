package io.pismo.challenge.repository;

import io.pismo.challenge.model.Account;
import io.pismo.challenge.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {

}
