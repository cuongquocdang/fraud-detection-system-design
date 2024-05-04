package com.example.walletservice.application.requesthandlers.services.impl;

import com.example.walletservice.application.requesthandlers.requests.CreateTransactionRequest;
import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;
import com.example.walletservice.application.requesthandlers.services.TransactionService;
import com.example.walletservice.domain.enums.TransactionStatus;
import com.example.walletservice.domain.enums.TransactionType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public CreateTransactionResponse execute(final CreateTransactionRequest request) {

        var transactionId = UUID.randomUUID().toString();

        // fake the execution of the transaction
        var transaction = CreateTransactionResponse.builder()
                .transactionId(transactionId)
                .transactionType(TransactionType.PAYMENT.getType())
                .debitAccount(request.getDebitAccount())
                .creditAccount(request.getCreditAccount())
                .amount(request.getAmount())
                .status(TransactionStatus.SUCCESSFUL.getStatus())
                .createdAt(System.currentTimeMillis())
                .build();

        return transaction;
    }
}
