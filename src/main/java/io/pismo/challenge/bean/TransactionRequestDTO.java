package io.pismo.challenge.bean;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;



import java.math.BigDecimal;

@Setter
@Getter
public class TransactionRequestDTO {

    @NotNull(message = "Account ID is required")
    private Long accountId;

    @NotNull(message = "Operation Type ID is required")
    private Long operationTypeId;

    @NotNull(message = "Amount is required")
    @PositiveOrZero(message = "Amount cannot be negative for credit transactions")
    private BigDecimal amount;

    @NotNull(message = "Event Date is required")
    private Long eventDate;

}
