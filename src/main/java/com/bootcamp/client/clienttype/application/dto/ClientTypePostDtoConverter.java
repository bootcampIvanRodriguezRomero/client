package com.bootcamp.client.clienttype.application.dto;

import com.bootcamp.client.clienttype.domain.model.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Converter interface for mapping between {@link ClientTypePostDto}
 * and {@link ClientType} entities.
 */
@Mapper(componentModel = "spring")
public interface ClientTypePostDtoConverter {
  ClientTypePostDtoConverter INSTANCE = Mappers.getMapper(ClientTypePostDtoConverter.class);
  
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "name", source = "clientTypePostDto.name")
  ClientType clientTypePostDtoToClientType(ClientTypePostDto clientTypePostDto);
}
