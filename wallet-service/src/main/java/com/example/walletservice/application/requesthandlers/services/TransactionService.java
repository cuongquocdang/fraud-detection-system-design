package com.example.walletservice.application.requesthandlers.services;

import com.example.walletservice.application.requesthandlers.requests.CreateTransactionRequest;
import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;

public interface TransactionService {

    CreateTransactionResponse execute(CreateTransactionRequest request);
}
