package com.bootcamp.client.clientType.infrastructure.converter;

import com.bootcamp.client.clientType.application.dto.ClientTypeDto;
import com.bootcamp.client.clientType.application.dto.ClientTypePostDto;
import com.bootcamp.client.clientType.domain.model.ClientType;
import com.bootcamp.client.clientType.infrastructure.dao.ClientTypeDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientTypeConverter {
    ClientTypeConverter INSTANCE = Mappers.getMapper(ClientTypeConverter.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "clientTypeDao.name")
    ClientType clientTypeDaoToClientType(ClientTypeDao clientTypeDao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "clientType.name")
    ClientTypeDto clientTypeToClientTypeDto(ClientType clientType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "clientTypePostDto.name")
    ClientType clientTypePostDtoToClientType(ClientTypePostDto clientTypePostDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "clientType.name")
    ClientTypeDao clientTypeToClientTypeDao(ClientType clientType);

}
