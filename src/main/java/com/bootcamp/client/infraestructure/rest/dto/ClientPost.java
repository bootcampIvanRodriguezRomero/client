package com.bootcamp.client.infraestructure.rest.dto;
import lombok.Data;
@Data
public class ClientPost {
    private String documentType;
    private String documentNumber;
    private String fullName;
}
