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
  @Mapping(target = "documentType", source = "clientDao.documentType")
  @Mapping(target = "documentNumber", source = "clientDao.documentNumber")
  @Mapping(target = "fullName", source = "clientDao.fullName")
  @Mapping(target = "email", source = "clientDao.email")
  @Mapping(target = "type", source = "clientDao.type")
  Client clientDaoToClient(ClientDao clientDao);
  
  @Mapping(target = "id", source = "client.id")
  @Mapping(target = "documentType", source = "client.documentType")
  @Mapping(target = "documentNumber", source = "client.documentNumber")
  @Mapping(target = "fullName", source = "client.fullName")
  @Mapping(target = "email", source = "client.email")
  @Mapping(target = "type", source = "client.type")
  ClientDao clientToClientDao(Client client);
}
