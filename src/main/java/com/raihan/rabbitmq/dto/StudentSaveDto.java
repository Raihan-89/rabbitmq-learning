package com.raihan.rabbitmq.dto;

import lombok.Data;

/**
 * @author Md. Raihan Shikder (Raihan-89)
 */
@Data
public class StudentSaveDto {
    private String fullName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String gender;
}
