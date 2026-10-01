package com.raihan.rabbitmq.publisher;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQPublisher {

    @Value("${rabbitmq.exchange.student-save-exchange}")
    private String studentSaveExchange;

    @Value("${rabbitmq.routing-key.student-save-routing-key}")
    private String studentSaveRoutingKey;

    private final RabbitTemplate rabbitTemplate;


    public String publishStudentSaveMessage(StudentSaveDto studentSaveDto) {
        log.info("Publishing student save message to RabbitMQ");

        try {

            rabbitTemplate.convertAndSend(studentSaveExchange, studentSaveRoutingKey, studentSaveDto);
            log.info("Student save message published to RabbitMQ");
        } catch (Exception e) {
            log.error("Failed to publish student save message to RabbitMQ: {}", e.getMessage());
        }

        return "Student Published to Save Successfully";
    }
}
