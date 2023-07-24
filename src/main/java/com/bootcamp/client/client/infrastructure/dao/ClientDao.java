package com.bootcamp.client.client.infrastructure.dao;

import com.bootcamp.client.client.domain.model.ClientData;
import com.bootcamp.client.clienttype.domain.model.ClientType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Data Access Object (DAO) representing a client entity.
 */
@Data
@Document("client")
public class ClientDao {
  @Id
  private String id;
  private ClientType type;
  private ClientData data;
}
