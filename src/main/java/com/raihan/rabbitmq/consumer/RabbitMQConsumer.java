package com.raihan.rabbitmq.consumer;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.repository.StudentInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final StudentInterface studentInterface;

    @RabbitListener(queues = "${rabbitmq.queue.student-save}")
    public void consumeStudentSaveMessage(StudentSaveDto studentSaveDto) {

        try {

            log.info("Received student save message from RabbitMQ: {}", studentSaveDto);

            String result = studentInterface.saveStudent(studentSaveDto);

            log.info("Result: {}", result);
        } catch (Exception e) {
            log.error("Failed to process student save message from RabbitMQ: {}", e.getMessage());
        }
    }
}
