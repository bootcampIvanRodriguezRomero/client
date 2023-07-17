package com.bootcamp.client.clienttype.infrastructure.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a client type stored in the database.
 * This class is mapped to the "clientType" collection in MongoDB.
 */
@Data
@Document("clientType")
public class ClientTypeDao {
  @Id
  private String id;
  private String name;
}
