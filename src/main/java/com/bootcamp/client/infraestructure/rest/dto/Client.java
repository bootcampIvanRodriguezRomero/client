package com.bootcamp.client.infraestructure.rest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class Client {
    @JsonProperty("identification")
    @Id
    private String id;
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
