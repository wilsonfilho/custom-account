package io.pismo.challenge.repository;

import io.pismo.challenge.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {

}
