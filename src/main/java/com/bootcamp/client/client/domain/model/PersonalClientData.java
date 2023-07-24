package com.bootcamp.client.client.domain.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@JsonTypeName("personalClientData")
public class PersonalClientData implements ClientData {
  @NotBlank(message = "Document type is required")
  private String documentType;
  @NotBlank(message = "Document number is required")
  private String documentNumber;
  @NotBlank(message = "Full name is required")
  private String fullName;
  private String email;
}
