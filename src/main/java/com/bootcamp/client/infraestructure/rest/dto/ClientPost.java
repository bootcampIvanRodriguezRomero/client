package com.bootcamp.client.infraestructure.rest.dto;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
@Data
public class ClientPost {
    @NotBlank(message = "document type is required")
    private String documentType;
    @NotBlank(message = "document number is required")
    private String documentNumber;
    @NotBlank(message = "full name is required")
    private String fullName;
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "type is required")
    private String type;
}
