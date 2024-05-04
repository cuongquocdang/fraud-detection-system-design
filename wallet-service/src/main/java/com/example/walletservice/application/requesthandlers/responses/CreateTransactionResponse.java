package com.example.walletservice.application.requesthandlers.responses;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateTransactionResponse {

    private int status;

    private long createdAt;

    private String transactionId;
    private String transactionType;
    private String debitAccount;
    private String creditAccount;

    private BigDecimal amount;
}