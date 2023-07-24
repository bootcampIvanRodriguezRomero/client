package com.bootcamp.client.client.application.dto;

import com.bootcamp.client.client.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting {@link ClientPostDto} entities to {@link Client} DTOs.
 */
@Mapper(componentModel = "spring")
public interface ClientPostDtoConverter {
  ClientPostDtoConverter INSTANCE = Mappers.getMapper(ClientPostDtoConverter.class);
  
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "type", ignore = true)
  @Mapping(target = "data", source = "clientPostDto.data")
  Client clientPostDtoToClient(ClientPostDto clientPostDto);
}
