package com.example.frauddetectionservice.infrastructure.redis;

import com.example.frauddetectionservice.application.dataproviders.TransactionRuleState;
import com.example.frauddetectionservice.shared.ServiceException;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisTransactionRuleState implements TransactionRuleState {

    private final RedissonClient redisClient;

    @Override
    public void addTransaction(final String accountNumber,
                               final String transactionId,
                               final Long timestamp) {
        var transactionSet = redisClient.getScoredSortedSet(accountNumber);

        if (!transactionSet.add(timestamp, transactionId)) {
            throw new ServiceException("Failed to add transaction");
        }
    }

    @Override
    public Integer countTransactionsInRange(final String accountNumber,
                                            final Long from,
                                            final Long to) {
        var transactionSet = redisClient.getScoredSortedSet(accountNumber);

        return transactionSet.count(from, true, to, true);
    }

    @Override
    public void removeTransactionsBefore(String accountNumber, Long timestamp) {
        var transactionSet = redisClient.getScoredSortedSet(accountNumber);

        transactionSet.removeRangeByScoreAsync(0L, true, timestamp, true);
    }
}
