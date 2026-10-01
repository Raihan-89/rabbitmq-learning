package com.raihan.rabbitmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.student-save}")
    private String studentSaveQueue;

    @Value("${rabbitmq.exchange.student-save-exchange}")
    private String studentExchange;

    @Value("${rabbitmq.routing-key.student-save-routing-key}")
    private String studentRoutingKey;

    @Bean
    public Queue studentSaveQueue() {
        return new Queue(studentSaveQueue);
    }

    @Bean
    public DirectExchange studentSaveExchange() {
        return new DirectExchange(studentExchange);
    }

    @Bean
    public Binding studentSaveBinding() {
        return BindingBuilder.bind(studentSaveQueue())
                .to(studentSaveExchange())
                .with(studentRoutingKey);
    }
}
