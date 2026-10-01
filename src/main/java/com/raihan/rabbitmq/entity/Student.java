package com.raihan.rabbitmq.entity;

import com.raihan.rabbitmq.dto.StudentSaveDto;
import com.raihan.rabbitmq.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    @Column(name = "full_name")
    private String fullName;

    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10)
    private Gender gender;

    public Student(StudentSaveDto studentDto) {
        this.fullName = studentDto.getFullName();
        this.dateOfBirth = LocalDate.parse(studentDto.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.email = studentDto.getEmail();
        this.phoneNumber = studentDto.getPhoneNumber();
        this.gender = Gender.valueOf(studentDto.getGender().toUpperCase());
    }
}
