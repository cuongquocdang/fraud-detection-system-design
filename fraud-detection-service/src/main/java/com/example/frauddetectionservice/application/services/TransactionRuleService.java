package com.example.frauddetectionservice.application.services;

import com.example.frauddetectionservice.application.messagehandlers.messages.TransactionMessage;

public interface TransactionRuleService {

    void process(TransactionMessage transaction);
}
