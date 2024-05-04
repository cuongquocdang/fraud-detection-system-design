package com.example.frauddetectionservice.infrastructure.kafka;

import com.example.frauddetectionservice.application.dataproviders.RuleHitProducer;
import com.example.frauddetectionservice.domain.enums.MessageCode;
import com.example.frauddetectionservice.application.dtos.RuleHitDTO;
import com.example.utilities.MessageBuilder;
import com.example.utilities.enums.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaRuleHitProducer implements RuleHitProducer {

    @Value("${spring.application.name}")
    private String serviceId;

    @Value("${kafka.rule-hit.topic}")
    private String ruleHitTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(final RuleHitDTO ruleHit) {

        var message =
                MessageBuilder.build(serviceId, EventType.EVENT, MessageCode.RULE_HIT.getCode(), ruleHit);

        kafkaTemplate.send(ruleHitTopic, message);
    }
}