package dev.darsh.fallback;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublisherFallback implements RabbitTemplate.ConfirmCallback {
    private static final Logger log = LoggerFactory.getLogger(PublisherFallback.class);

    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
        if (ack){
            log.info("Acknowledge confirmation");
        }
        else {
            log.info("No confirmation with cause : {}", cause);
        }
    }
}
