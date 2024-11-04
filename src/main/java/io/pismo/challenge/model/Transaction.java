package io.pismo.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @Column(name = "operation_type_id")
    private Long operationType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENT_DATE")
    private LocalDateTime eventDate;

    // Getters and Setters
}
