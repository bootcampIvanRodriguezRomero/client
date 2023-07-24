package com.bootcamp.client.client.domain.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonTypeName("businessClientData")
public class BusinessClientData implements ClientData {
  @NotBlank(message = "Business name is required")
  private String businessName;
  @NotBlank(message = "Registration number is required")
  private String registrationNumber;
  private String email;
}
