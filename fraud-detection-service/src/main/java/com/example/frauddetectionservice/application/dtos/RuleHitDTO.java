package com.example.frauddetectionservice.application.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleHitDTO {

    private long issuedAt;

    private String accountNumber;
    private String ruleId;
    private String transactionId;
}