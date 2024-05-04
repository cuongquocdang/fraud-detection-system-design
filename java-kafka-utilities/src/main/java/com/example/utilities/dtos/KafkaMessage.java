package com.example.utilities.dtos;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class KafkaMessage<T> extends MessageBase {

    private T payload;
}