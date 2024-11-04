package io.pismo.challenge.controller;

import io.pismo.challenge.bean.TransactionRequestDTO;
import io.pismo.challenge.exceptions.OperationTypeNotFoundException;
import io.pismo.challenge.model.Transaction;
import io.pismo.challenge.service.TransactionService;
import io.pismo.challenge.exceptions.AccountNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Creates a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction successfully created"),
            @ApiResponse(responseCode = "404", description = "Account or Operation Type not found")
    })
    @PostMapping("/save")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequestDTO transaction) {
        try {
            Transaction createdTransaction = transactionService.createTransaction(
                    transaction.getAccountId(),
                    transaction.getOperationTypeId(),
                    transaction.getAmount()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
        } catch (AccountNotFoundException | OperationTypeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
