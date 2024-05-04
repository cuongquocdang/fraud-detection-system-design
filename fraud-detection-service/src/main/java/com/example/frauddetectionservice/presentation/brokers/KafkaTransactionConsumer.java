package com.example.frauddetectionservice.presentation.brokers;

import com.example.frauddetectionservice.presentation.dtos.KafkaTransactionDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaTransactionConsumer {

    @KafkaListener(
            topics = "${kafka.transaction.topic}",
            properties = {"spring.json.value.default.type=com.example.frauddetectionservice.presentation.dtos.KafkaTransactionDTO"},
            concurrency = "${kafka.transaction.concurrency}"
    )
    @SneakyThrows
    public void listenTransactions(@Payload final KafkaTransactionDTO message) {
        log.info("Received a transaction message - code: {} - meta: {} - payload: {}",
                message.getMessageCode(), message.getMeta(), message.getPayload());
    }
}
