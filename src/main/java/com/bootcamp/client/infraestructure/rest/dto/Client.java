package com.bootcamp.client.infraestructure.rest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Client {
    @JsonProperty("identification")
    private String id;
    private String documentType;
    private String documentNumber;
    private String fullName;
}
