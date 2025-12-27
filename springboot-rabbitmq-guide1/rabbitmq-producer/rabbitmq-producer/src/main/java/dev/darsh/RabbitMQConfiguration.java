package dev.darsh;

import dev.darsh.fallback.PublisherFallback;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfiguration {

    private final PublisherFallback publisherFallback;

    @Bean
    public Queue queue() {
        return new Queue("products");
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("exchange.direct");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("products.binding.key");
    }
}
