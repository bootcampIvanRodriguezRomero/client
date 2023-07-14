package com.bootcamp.client.infraestructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ClientTypeDto {
    @JsonProperty("identification")
    @Id
    private String id;
    private String name;
}
