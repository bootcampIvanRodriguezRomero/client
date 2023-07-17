package com.bootcamp.client.clienttype.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Data transfer object (DTO) for creating a new client type.
 * It contains the required fields for creating a client type: name.
 */
@Data
public class ClientTypePostDto {
  @NotBlank(message = "Name is required")
  private String name;
}
