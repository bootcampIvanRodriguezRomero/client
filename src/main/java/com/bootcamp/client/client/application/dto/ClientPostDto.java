package com.bootcamp.client.client.application.dto;

import com.bootcamp.client.client.domain.model.ClientData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Data transfer object representing a client for sending.
 * This class specifically represents the client information sent by the application.
 * It is used to transfer client data from the application to external systems or APIs.
 */
@Data
public class ClientPostDto {
  @NotBlank(message = "type is required")
  private String type;
  @Valid
  private ClientData data;
}
