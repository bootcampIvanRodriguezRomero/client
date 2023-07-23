package com.bootcamp.client.clienttype.application.services;

import com.bootcamp.client.clienttype.application.dto.ClientTypeDto;
import com.bootcamp.client.clienttype.application.dto.ClientTypeDtoConverter;
import com.bootcamp.client.clienttype.application.dto.ClientTypePostDto;
import com.bootcamp.client.clienttype.application.dto.ClientTypePostDtoConverter;
import com.bootcamp.client.clienttype.domain.model.ClientType;
import com.bootcamp.client.clienttype.domain.repositories.ClientTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementation of the ClientTypeService interface.
 * Provides methods to manage client types.
 */
@Service
@RequiredArgsConstructor
public class ClientTypeServiceImpl implements ClientTypeService {
  
  private final ClientTypeRepository clientTypeRepository;
  
  @Override
  public Flux<ClientTypeDto> getAllClientTypes() {
    return clientTypeRepository.findAll()
      .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
  }
  
  @Override
  public Mono<ClientTypeDto> getClientTypeById(String id) {
    return clientTypeRepository.findById(id)
      .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
  }
  
  @Override
  public Mono<ClientTypeDto> createClientType(ClientTypePostDto clientTypePostDto) {
    return clientTypeRepository.existsByName(clientTypePostDto.getName())
      .flatMap(nameExists -> {
        if (nameExists) {
          return Mono.error(
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name already exists"));
        } else {
          ClientType clientType =
              ClientTypePostDtoConverter.INSTANCE.clientTypePostDtoToClientType(clientTypePostDto);
          return clientTypeRepository.save(clientType)
            .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
        }
      });
  }
  
  @Override
  public Mono<ClientTypeDto> modifyClientType(String id, ClientTypePostDto clientTypePostDto) {
    return clientTypeRepository.findById(id)
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Client type not found")))
            .flatMap(existingclientType -> {
              ClientType modifiedClientType =
                  ClientTypePostDtoConverter.INSTANCE.clientTypePostDtoToClientType(
                  clientTypePostDto);
              modifiedClientType.setId(existingclientType.getId());
              return clientTypeRepository.save(modifiedClientType);
            })
            .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
  }
  
  @Override
  public Mono<Void> deleteClientType(String id) {
    
    return clientTypeRepository.deleteById(id);
  }
  
  @Override
  public Mono<Void> deleteAllClientTypes() {
    
    return clientTypeRepository.deleteAll();
  }
  
}
