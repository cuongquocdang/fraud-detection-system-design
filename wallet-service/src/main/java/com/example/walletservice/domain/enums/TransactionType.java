package com.example.walletservice.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {
    PAYMENT("PAYMENT"),
    TOPUP("TOPUP"),
    ;

    private final String type;
}
