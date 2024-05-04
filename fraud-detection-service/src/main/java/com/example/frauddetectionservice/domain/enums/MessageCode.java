package com.example.frauddetectionservice.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum MessageCode {
    RULE_HIT("RULE_HIT"),
    ;

    private final String code;
}