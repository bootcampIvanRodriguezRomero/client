package com.bootcamp.client.client.infrastructure.dao;

import com.bootcamp.client.client.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Converter interface responsible for mapping between {@link ClientDao}
 * and {@link Client} entities.
 */
@Mapper(componentModel = "spring")
public interface ClientDaoConverter {
  ClientDaoConverter INSTANCE = Mappers.getMapper(ClientDaoConverter.class);
  
  @Mapping(target = "id", source = "clientDao.id")
  @Mapping(target = "type", source = "clientDao.type")
  @Mapping(target = "data", source = "clientDao.data")
  Client clientDaoToClient(ClientDao clientDao);
  
  @Mapping(target = "id", source = "client.id")
  @Mapping(target = "type", source = "client.type")
  @Mapping(target = "data", source = "client.data")
  ClientDao clientToClientDao(Client client);
}
