package com.raihan.rabbitmq.controller;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.repository.StudentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentInterface studentInterface;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(StudentSaveDto studentDto) {
        String result = studentInterface.saveStudent(studentDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-by-email")
    public ResponseEntity<?> getStudentByEmail(String email) {
        return ResponseEntity.ok(studentInterface.getStudentByEmail(email));
    }

    @GetMapping("/get-by-phoneNumber")
    public ResponseEntity<?> getStudentByPhoneNumber(String phoneNumber) {
        return ResponseEntity.ok(studentInterface.getStudentByPhoneNumber(phoneNumber));
    }
}
