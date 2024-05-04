package com.example.frauddetectionservice.presentation.mappings;

import com.example.frauddetectionservice.application.messagehandlers.messages.TransactionMessage;
import com.example.frauddetectionservice.presentation.dtos.TransactionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapping {

    TransactionMessage mapToTransactionMessage(TransactionDTO input);
}
