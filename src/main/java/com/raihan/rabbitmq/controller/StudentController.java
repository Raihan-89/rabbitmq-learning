package com.raihan.rabbitmq.controller;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.publisher.RabbitMQPublisher;
import com.raihan.rabbitmq.repository.StudentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final RabbitMQPublisher rabbitMQPublisher;
    private final StudentInterface studentInterface;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentSaveDto studentDto) {

        String result = rabbitMQPublisher.publishStudentSaveMessage(studentDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-by-email")
    public ResponseEntity<?> getStudentByEmail(@RequestBody String email) {
        return ResponseEntity.ok(studentInterface.getStudentByEmail(email));
    }

    @GetMapping("/get-by-phoneNumber")
    public ResponseEntity<?> getStudentByPhoneNumber(@RequestBody String phoneNumber) {
        return ResponseEntity.ok(studentInterface.getStudentByPhoneNumber(phoneNumber));
    }
}
