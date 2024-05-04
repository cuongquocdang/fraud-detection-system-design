package com.example.walletservice.application.dataproviders;

import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;

public interface TransactionProducer {

    void send(CreateTransactionResponse transaction);
}