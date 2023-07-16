package com.bootcamp.client.client.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientPostDto {
    @NotBlank(message = "document type is required")
    private String documentType;
    @NotBlank(message = "document number is required")
    private String documentNumber;
    @NotBlank(message = "full name is required")
    private String fullName;
    @NotBlank(message = "email is required")
    @Email
    private String email;
    @NotBlank(message = "type is required")
    private String type;
}
