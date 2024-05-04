package com.example.walletservice.presentation.restcontrollers;

import com.example.utilities.RequestChain;
import com.example.utilities.RequestHandler;
import com.example.walletservice.application.requesthandlers.requests.CreateTransactionRequest;
import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;
import com.example.walletservice.presentation.dtos.TransactionRequestDTO;
import com.example.walletservice.presentation.dtos.TransactionResponseDTO;
import com.example.walletservice.presentation.mappings.ContractMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentRestController {

    private final RequestHandler<CreateTransactionRequest, CreateTransactionResponse> createTransactionRequestHandler;
    private final ContractMapping contractMapping;

    @PostMapping
    public TransactionResponseDTO createTransaction(@RequestBody TransactionRequestDTO request) {
        return RequestChain.of(contractMapping.mapToCreateTransactionRequest(request))
                .thenApply(createTransactionRequestHandler::handle)
                .thenApply(contractMapping::mapToTransactionResponseDTO)
                .getResult();
    }
}
