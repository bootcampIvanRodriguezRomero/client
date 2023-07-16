package com.bootcamp.client.client.application.dto;
import com.bootcamp.client.client.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ClientDtoConverter {
    ClientDtoConverter INSTANCE = Mappers.getMapper(ClientDtoConverter.class);
    @Mapping(target = "id", source = "client.id")
    @Mapping(target = "documentType", source = "client.documentType")
    @Mapping(target = "documentNumber", source = "client.documentNumber")
    @Mapping(target = "fullName", source = "client.fullName")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "type", source = "client.type")
    ClientDto clientToClientDto(Client client);

}
