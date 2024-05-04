package com.example.walletservice.presentation.dtos;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class TransactionResponseDTO {

    private int status;

    private long createdAt;

    private String transactionId;
    private String transactionType;
    private String debitAccount;
    private String creditAccount;

    private BigDecimal amount;
}
