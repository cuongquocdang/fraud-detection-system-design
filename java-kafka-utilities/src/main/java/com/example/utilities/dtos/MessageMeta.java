package com.example.utilities.dtos;

import com.example.utilities.enums.EventType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MessageMeta {

    private boolean autoRetry;

    private long timestamp;

    private String messageId;
    private String originalMessageId;
    private String serviceId;

    private EventType type;
}
