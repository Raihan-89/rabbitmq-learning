package com.raihan.rabbitmq.service;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.entity.Student;
import com.raihan.rabbitmq.repository.StudentInterface;
import com.raihan.rabbitmq.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService implements StudentInterface {

    private final StudentRepository studentRepository;

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student getStudentByPhoneNumber(String phoneNumber) {
        return studentRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public String saveStudent(StudentSaveDto studentDto) {
        try {
            Student student = studentRepository.findByEmail(studentDto.getEmail());
            if (student != null) {
                return "Email is already registered";
            }

            student = studentRepository.findByPhoneNumber(studentDto.getPhoneNumber());

            if (student != null) {
                return "Phone number is already registered";
            }

            student = new Student(studentDto);

            studentRepository.save(student);
            log.info("Student saved successfully: {}", student);
        } catch (Exception e) {
            log.error("Failed to save student: {}", e.getMessage());
            return "Failed to save student";
        }

        return "Student saved successfully.";
    }
}
