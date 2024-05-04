package com.example.walletservice.application.requesthandlers.commands;

import com.example.utilities.RequestHandler;
import com.example.walletservice.application.requesthandlers.requests.CreateTransactionRequest;
import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;
import com.example.walletservice.application.requesthandlers.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTransactionRequestHandler
        implements RequestHandler<CreateTransactionRequest, CreateTransactionResponse> {

    private final TransactionService transactionService;

    @Override
    public CreateTransactionResponse handle(final CreateTransactionRequest request) {
        return transactionService.execute(request);
    }
}