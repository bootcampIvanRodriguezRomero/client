package com.bootcamp.client.infraestructure.rest.dto;
import com.bootcamp.client.infraestructure.repository.dao.ClientTypeDao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class ClientDto {
    @JsonProperty("identification")
    @Id
    private String id;
    private String documentType;
    private String documentNumber;
    private String fullName;
    private String email;
    private ClientTypeDao type;
}
