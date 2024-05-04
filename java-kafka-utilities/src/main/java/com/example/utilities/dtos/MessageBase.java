package com.example.utilities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class MessageBase {

    protected String messageCode;

    protected MessageMeta meta;
}