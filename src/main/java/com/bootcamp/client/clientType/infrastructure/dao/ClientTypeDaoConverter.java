package com.bootcamp.client.clientType.infrastructure.dao;
import com.bootcamp.client.clientType.domain.model.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

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
