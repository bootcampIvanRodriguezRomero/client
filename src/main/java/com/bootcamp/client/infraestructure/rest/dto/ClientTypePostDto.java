package com.bootcamp.client.infraestructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientTypePostDto {
    @NotBlank(message = "Name is required")
    private String name;
}
