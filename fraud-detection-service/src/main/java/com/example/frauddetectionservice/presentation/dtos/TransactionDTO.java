package com.example.frauddetectionservice.presentation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private int status;

    private long createdAt;

    private String transactionId;
    private String transactionType;
    private String debitAccount;
    private String creditAccount;

    private BigDecimal amount;
}