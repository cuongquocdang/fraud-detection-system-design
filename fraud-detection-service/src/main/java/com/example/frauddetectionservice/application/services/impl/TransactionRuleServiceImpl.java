package com.example.frauddetectionservice.application.services.impl;

import com.example.frauddetectionservice.application.dataproviders.RuleHitProducer;
import com.example.frauddetectionservice.application.dataproviders.TransactionRuleState;
import com.example.frauddetectionservice.application.dtos.RuleHitDTO;
import com.example.frauddetectionservice.application.messagehandlers.messages.TransactionMessage;
import com.example.frauddetectionservice.application.services.TransactionRuleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionRuleServiceImpl implements TransactionRuleService {

    private final TransactionRuleState transactionRuleState;
    private final RuleHitProducer ruleHitProducer;

    @Value("${rules.max-transactions-last-minutes.id}")
    private String ruleId;

    @Value("${rules.max-transactions-last-minutes.minutes}")
    private Integer periodInMinutes;

    @Value("${rules.max-transactions-last-minutes.max-transactions}")
    private Integer maxTransactions;

    private Integer periodInMs;

    @PostConstruct
    public void init() {
        periodInMs = periodInMinutes * 60 * 1000;
    }

    @Override
    public void process(final TransactionMessage transaction) {
        processMaxTransactionsLastMinutes(transaction.getDebitAccount(), transaction);
        processMaxTransactionsLastMinutes(transaction.getCreditAccount(), transaction);
    }

    private void processMaxTransactionsLastMinutes(final String accountNumber,
                                                   final TransactionMessage transaction) {

        transactionRuleState.addTransaction(accountNumber, transaction.getTransactionId(), transaction.getCreatedAt());

        var from = transaction.getCreatedAt() - periodInMs;
        var transactionCount =
                transactionRuleState.countTransactionsInRange(accountNumber, from, transaction.getCreatedAt());
        log.info("[{}] Account number {} has {} transactions from {} to {}",
                ruleId, accountNumber, transactionCount, from, transaction.getCreatedAt());

        if (transactionCount >= maxTransactions) {
            var ruleHit = RuleHitDTO.builder()
                    .accountNumber(accountNumber)
                    .ruleId(ruleId)
                    .issuedAt(transaction.getCreatedAt())
                    .transactionId(transaction.getTransactionId())
                    .build();

            log.info("[{}] Account number {} hit the rule with transaction id {}",
                    ruleId, accountNumber, transaction.getTransactionId());
            ruleHitProducer.send(ruleHit);
        }

        CompletableFuture.runAsync(() -> transactionRuleState.removeTransactionsBefore(accountNumber, from));
    }
}
