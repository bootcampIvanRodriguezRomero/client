package com.bootcamp.client.clienttype.application.dto;

import com.bootcamp.client.clienttype.domain.model.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface that converts {@link ClientType} entities to {@link ClientTypeDto} objects.
 * It uses the MapStruct library for object mapping. The interface defines a single method
 * to convert a {@link ClientType} object to a {@link ClientTypeDto} object,
 * mapping the id and name fields.
 */
@Mapper(componentModel = "spring")
public interface ClientTypeDtoConverter {
  
  ClientTypeDtoConverter INSTANCE = Mappers.getMapper(ClientTypeDtoConverter.class);
  
  @Mapping(target = "id", source = "clientType.id")
  @Mapping(target = "name", source = "clientType.name")
  ClientTypeDto clientTypeToClientTypeDto(ClientType clientType);
}
