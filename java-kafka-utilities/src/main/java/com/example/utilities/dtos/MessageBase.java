package com.example.utilities.dtos;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class MessageBase {

    protected String messageCode;

    protected MessageMeta meta;
}