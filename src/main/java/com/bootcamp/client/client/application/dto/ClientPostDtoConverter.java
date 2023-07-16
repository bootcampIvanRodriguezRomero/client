package com.bootcamp.client.client.application.dto;
import com.bootcamp.client.client.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ClientPostDtoConverter {
    ClientPostDtoConverter INSTANCE = Mappers.getMapper(ClientPostDtoConverter.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "documentType", source = "clientPostDto.documentType")
    @Mapping(target = "documentNumber", source = "clientPostDto.documentNumber")
    @Mapping(target = "fullName", source = "clientPostDto.fullName")
    @Mapping(target = "email", source = "clientPostDto.email")
    @Mapping(target = "type", ignore = true)
    Client clientPostDtoToClient(ClientPostDto clientPostDto);
}
