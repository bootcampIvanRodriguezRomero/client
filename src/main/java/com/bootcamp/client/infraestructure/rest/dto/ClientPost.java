package com.bootcamp.client.infraestructure.rest.dto;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
@Data
public class ClientPost {
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
