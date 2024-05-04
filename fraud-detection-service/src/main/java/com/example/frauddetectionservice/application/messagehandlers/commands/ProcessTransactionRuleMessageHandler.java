package com.example.frauddetectionservice.application.messagehandlers.commands;

import com.example.frauddetectionservice.application.messagehandlers.messages.TransactionMessage;
import com.example.frauddetectionservice.application.services.TransactionRuleService;
import com.example.utilities.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProcessTransactionRuleMessageHandler implements MessageHandler<TransactionMessage> {

    private final TransactionRuleService transactionRuleService;

    @Override
    public void handle(final TransactionMessage transactionMessage) {
        transactionRuleService.process(transactionMessage);
    }
}
