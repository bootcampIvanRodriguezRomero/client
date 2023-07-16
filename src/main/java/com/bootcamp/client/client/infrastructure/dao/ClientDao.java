package com.bootcamp.client.client.infrastructure.dao;

import com.bootcamp.client.clientType.domain.model.ClientType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("client")
public class ClientDao {
    @Id
    private String id;
    private String documentType;
    private String documentNumber;
    private String fullName;
    private String email;
    private ClientType type;
}
