package com.bootcamp.client.client.domain.model;

import com.bootcamp.client.clientType.domain.model.ClientType;
import lombok.Data;

@Data
public class Client {
    private String id;
    private String documentType;
    private String documentNumber;
    private String fullName;
    private String email;
    private ClientType type;
}
