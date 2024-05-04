package com.example.walletservice.application.requesthandlers.requests;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateTransactionRequest {

    private String debitAccount;
    private String creditAccount;

    private BigDecimal amount;
}