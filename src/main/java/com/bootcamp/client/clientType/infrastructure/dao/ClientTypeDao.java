package com.bootcamp.client.clientType.infrastructure.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("clientType")
public class ClientTypeDao {
    @Id
    private String id;
    private String name;
}