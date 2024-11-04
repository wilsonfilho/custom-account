package io.pismo.challenge.service;

import io.pismo.challenge.exceptions.OperationTypeNotFoundException;
import io.pismo.challenge.model.Account;
import io.pismo.challenge.model.OperationType;
import io.pismo.challenge.model.Transaction;
import io.pismo.challenge.repository.AccountRepository;
import io.pismo.challenge.repository.OperationTypeRepository;
import io.pismo.challenge.repository.TransactionRepository;
import io.pismo.challenge.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction createTransaction(Long accountId, Long operationTypeId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account with ID " + accountId + " not found"));

        OperationType operationType = operationTypeRepository.findById(operationTypeId)
                .orElseThrow(() -> new OperationTypeNotFoundException("Operation Type with ID " + operationTypeId + " not found"));

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setOperationType(operationType.getId());
        transaction.setAmount(amount);
        transaction.setEventDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
