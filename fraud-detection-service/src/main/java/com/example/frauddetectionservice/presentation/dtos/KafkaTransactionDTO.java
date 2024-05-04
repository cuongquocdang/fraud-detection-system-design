package com.example.frauddetectionservice.presentation.dtos;

import com.example.utilities.dtos.KafkaMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class KafkaTransactionDTO extends KafkaMessage<TransactionDTO> {
}