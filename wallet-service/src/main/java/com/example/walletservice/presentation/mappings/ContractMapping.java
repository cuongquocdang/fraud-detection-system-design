package com.example.walletservice.presentation.mappings;

import com.example.walletservice.application.requesthandlers.requests.CreateTransactionRequest;
import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;
import com.example.walletservice.presentation.dtos.TransactionRequestDTO;
import com.example.walletservice.presentation.dtos.TransactionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapping {

    CreateTransactionRequest mapToCreateTransactionRequest(TransactionRequestDTO input);

    TransactionResponseDTO mapToTransactionResponseDTO(CreateTransactionResponse input);
}