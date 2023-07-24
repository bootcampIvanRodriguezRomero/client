package com.bootcamp.client.client.domain.model;

import com.bootcamp.client.clienttype.domain.model.ClientType;
import lombok.Data;

/**
 * Represents a client.
 */
@Data
public class Client {
  private String id;
  private ClientType type;
  private ClientData data;
}
