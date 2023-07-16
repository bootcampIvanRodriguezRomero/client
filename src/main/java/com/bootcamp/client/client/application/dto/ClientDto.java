package com.bootcamp.client.client.application.dto;

import com.bootcamp.client.clientType.domain.model.ClientType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientDto {
    @JsonProperty("identification")
    private String id;
    private String documentType;
    private String documentNumber;
    private String fullName;
    private String email;
    private ClientType type;
}
