package com.bootcamp.client.client.application.dto;

import com.bootcamp.client.client.domain.model.ClientData;
import com.bootcamp.client.clienttype.domain.model.ClientType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data transfer object representing a client for reception.
 * This class specifically represents the client information received by the application.
 * It is used to transfer client data from the application to external systems or APIs.
 */
@Data
public class ClientDto {
  @JsonProperty("identification")
  private String id;
  private ClientType type;
  private ClientData data;
}
