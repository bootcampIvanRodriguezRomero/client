package com.bootcamp.client.client.infrastructure.converter;

import com.bootcamp.client.client.application.dto.ClientDto;
import com.bootcamp.client.client.application.dto.ClientPostDto;
import com.bootcamp.client.client.domain.model.Client;
import com.bootcamp.client.client.infrastructure.dao.ClientDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientConverter {
    ClientConverter INSTANCE = Mappers.getMapper(ClientConverter.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "documentType", source = "clientDao.documentType")
    @Mapping(target = "documentNumber", source = "clientDao.documentNumber")
    @Mapping(target = "fullName", source = "clientDao.fullName")
    @Mapping(target = "email", source = "clientDao.email")
    @Mapping(target = "type", expression = "java(clientDao.getType())")
    Client clientDaoToClient(ClientDao clientDao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "documentType", source = "client.documentType")
    @Mapping(target = "documentNumber", source = "client.documentNumber")
    @Mapping(target = "fullName", source = "client.fullName")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "type", expression = "java(client.getType())")
    ClientDto clientToClientDto(Client client);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "documentType", source = "clientPostDto.documentType")
    @Mapping(target = "documentNumber", source = "clientPostDto.documentNumber")
    @Mapping(target = "fullName", source = "clientPostDto.fullName")
    @Mapping(target = "email", source = "clientPostDto.email")
    @Mapping(target = "type", ignore = true)
    Client clientPostDtoToClient(ClientPostDto clientPostDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "documentType", source = "client.documentType")
    @Mapping(target = "documentNumber", source = "client.documentNumber")
    @Mapping(target = "fullName", source = "client.fullName")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "type", expression = "java(client.getType())")
    ClientDao clientToClientDao(Client client);

}
