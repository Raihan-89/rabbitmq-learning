package com.raihan.rabbitmq.entity;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Date of birth is required")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
    private String phoneNumber;

    @NotNull(message = "Gender is required")
    private Gender gender;

    public Student(StudentSaveDto studentDto) {
        this.fullName = studentDto.getFullName();
        this.dateOfBirth = LocalDate.parse(studentDto.getDateOfBirth());
        this.email = studentDto.getEmail();
        this.phoneNumber = studentDto.getPhoneNumber();
        this.gender = Gender.valueOf(studentDto.getGender().toUpperCase());
    }
}
