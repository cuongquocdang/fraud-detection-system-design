package com.example.frauddetectionservice.application.dataproviders;

import com.example.frauddetectionservice.application.dtos.RuleHitDTO;

public interface RuleHitProducer {

    void send(RuleHitDTO ruleHit);
}