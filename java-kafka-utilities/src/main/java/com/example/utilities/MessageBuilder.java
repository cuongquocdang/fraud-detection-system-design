package com.example.utilities;

import com.example.utilities.dtos.KafkaMessage;
import com.example.utilities.dtos.MessageMeta;
import com.example.utilities.enums.EventType;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class MessageBuilder {

    public static <T> KafkaMessage<T> build(final String serviceId,
                                            final EventType eventType,
                                            final String messageCode,
                                            final T payload) {

        var meta = MessageMeta.builder()
                .messageId(generateMessageId())
                .serviceId(serviceId)
                .type(eventType)
                .timestamp(generateMessageTimestamp())
                .build();

        return KafkaMessage.<T>builder()
                .meta(meta)
                .messageCode(messageCode)
                .payload(payload)
                .build();
    }

    public static String generateMessageId() {
        return UUID.randomUUID().toString().replace("_", "");
    }

    public static long generateMessageTimestamp() {
        return System.currentTimeMillis();
    }
}
