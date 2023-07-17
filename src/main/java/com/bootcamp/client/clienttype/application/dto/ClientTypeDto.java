package com.bootcamp.client.clienttype.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Data Transfer Object (DTO) class that represents the client type data.
 * It is used to transfer client type information between the application
 * layer and external systems or APIs. The DTO contains the identification
 * and name fields of a client type.
 */
@Data
public class ClientTypeDto {
  @JsonProperty("identification")
  @Id
  private String id;
  private String name;
}