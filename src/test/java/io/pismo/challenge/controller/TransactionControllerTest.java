package io.pismo.challenge.controller;

import io.pismo.challenge.bean.TransactionRequestDTO;
import io.pismo.challenge.exceptions.OperationTypeNotFoundException;
import io.pismo.challenge.model.Transaction;
import io.pismo.challenge.service.TransactionService;
import io.pismo.challenge.exceptions.AccountNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransactionSuccess() {
        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setAccountId(1L);
        request.setOperationTypeId(1L);
        request.setAmount(BigDecimal.valueOf(100));

        Transaction transaction = new Transaction();
        transaction.setId(1L);

        when(transactionService.createTransaction(1L, 1L, BigDecimal.valueOf(100))).thenReturn(transaction);

        ResponseEntity<?> response = transactionController.createTransaction(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(transaction, response.getBody());
        verify(transactionService, times(1)).createTransaction(1L, 1L, BigDecimal.valueOf(100));
    }

    @Test
    void testCreateTransactionAccountNotFound() {
        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setAccountId(1L);
        request.setOperationTypeId(1L);
        request.setAmount(BigDecimal.valueOf(100));

        when(transactionService.createTransaction(any(), any(), any()))
                .thenThrow(new AccountNotFoundException("Account not found"));

        ResponseEntity<?> response = transactionController.createTransaction(request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Account not found", response.getBody());
    }

    @Test
    void testCreateTransactionOperationTypeNotFound() {
        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setAccountId(1L);
        request.setOperationTypeId(1L);
        request.setAmount(BigDecimal.valueOf(100));

        when(transactionService.createTransaction(any(), any(), any()))
                .thenThrow(new OperationTypeNotFoundException("Operation Type not found"));

        ResponseEntity<?> response = transactionController.createTransaction(request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Operation Type not found", response.getBody());
    }
}
