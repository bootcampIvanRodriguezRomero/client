package com.bootcamp.client.clienttype.infrastructure.dao;

import com.bootcamp.client.clienttype.domain.model.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Converter interface to convert between ClientType and ClientTypeDao objects.
 * Uses MapStruct for automatic mapping implementation.
 * This interface provides methods to convert a ClientType to ClientTypeDao and vice versa.
 */
@Mapper(componentModel = "spring")
public interface ClientTypeDaoConverter {
  ClientTypeDaoConverter INSTANCE = Mappers.getMapper(ClientTypeDaoConverter.class);
  
  @Mapping(target = "id", source = "clientTypeDao.id")
  @Mapping(target = "name", source = "clientTypeDao.name")
  ClientType clientTypeDaoToClientType(ClientTypeDao clientTypeDao);
  
  @Mapping(target = "id", source = "clientType.id")
  @Mapping(target = "name", source = "clientType.name")
  ClientTypeDao clientTypeToClientTypeDao(ClientType clientType);
}
