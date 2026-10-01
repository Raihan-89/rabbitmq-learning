package com.raihan.rabbitmq.repository;

import com.raihan.rabbitmq.entity.Student;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);

    Student findByPhoneNumber(String phoneNumber);
}
