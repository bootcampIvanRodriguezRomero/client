package com.bootcamp.client.clientType.application.dto;
import com.bootcamp.client.clientType.domain.model.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientTypePostDtoConverter {
    ClientTypePostDtoConverter INSTANCE = Mappers.getMapper(ClientTypePostDtoConverter.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "clientTypePostDto.name")
    ClientType clientTypePostDtoToClientType(ClientTypePostDto clientTypePostDto);
}
