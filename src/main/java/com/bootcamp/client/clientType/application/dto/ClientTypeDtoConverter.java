package com.bootcamp.client.clientType.application.dto;
import com.bootcamp.client.clientType.domain.model.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientTypeDtoConverter {

    ClientTypeDtoConverter INSTANCE = Mappers.getMapper(ClientTypeDtoConverter.class);
    @Mapping(target = "id", source = "clientType.id")
    @Mapping(target = "name", source = "clientType.name")
    ClientTypeDto clientTypeToClientTypeDto(ClientType clientType);
}
