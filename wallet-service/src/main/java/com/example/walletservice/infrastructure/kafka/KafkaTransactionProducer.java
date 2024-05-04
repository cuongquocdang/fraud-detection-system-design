package com.example.walletservice.infrastructure.kafka;

import com.example.utilities.MessageBuilder;
import com.example.utilities.enums.EventType;
import com.example.walletservice.application.dataproviders.TransactionProducer;
import com.example.walletservice.application.requesthandlers.responses.CreateTransactionResponse;
import com.example.walletservice.domain.enums.MessageCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaTransactionProducer implements TransactionProducer {

    @Value("${kafka.transaction}")
    private String transactionTopic;

    @Value("${spring.application.name}")
    private String serviceId;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(final CreateTransactionResponse transaction) {

        var message =
                MessageBuilder.build(serviceId, EventType.EVENT, MessageCode.FUND_TRANSFER.getCode(), transaction);

        kafkaTemplate.send(transactionTopic, message);
    }
}