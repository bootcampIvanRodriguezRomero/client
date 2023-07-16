package com.bootcamp.client.clientType.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ClientTypeDto {
    @JsonProperty("identification")
    @Id
    private String id;
    private String name;
}