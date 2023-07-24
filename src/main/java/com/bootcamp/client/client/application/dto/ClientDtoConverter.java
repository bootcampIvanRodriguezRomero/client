package com.bootcamp.client.client.application.dto;

import com.bootcamp.client.client.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting {@link Client} entities to {@link ClientDto} DTOs.
 */
@Mapper(componentModel = "spring")
public interface ClientDtoConverter {
  ClientDtoConverter INSTANCE = Mappers.getMapper(ClientDtoConverter.class);
  
  @Mapping(target = "id", source = "client.id")
  @Mapping(target = "type", source = "client.type")
  @Mapping(target = "data", source = "client.data")
  ClientDto clientToClientDto(Client client);
  
}
