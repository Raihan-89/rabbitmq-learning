package com.raihan.rabbitmq.repository;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.entity.Student;
import org.springframework.stereotype.Component;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Component
public interface StudentInterface {
    String saveStudent(StudentSaveDto studentDto);

    Student getStudentByEmail(String email);

    Student getStudentByPhoneNumber(String phoneNumber);
}
