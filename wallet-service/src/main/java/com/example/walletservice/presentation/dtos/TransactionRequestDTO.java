package com.example.walletservice.presentation.dtos;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class TransactionRequestDTO {

    private String debitAccount;
    private String creditAccount;

    private BigDecimal amount;
}