package com.example.frauddetectionservice.application.dataproviders;

public interface TransactionRuleState {

    void addTransaction(String accountNumber, String transactionId, Long timestamp);

    Integer countTransactionsInRange(String accountNumber, Long from, Long to);

    void removeTransactionsBefore(String accountNumber, Long timestamp);
}