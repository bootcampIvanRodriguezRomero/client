package com.bootcamp.client.clienttype.application.services;

import com.bootcamp.client.clienttype.application.dto.ClientTypeDto;
import com.bootcamp.client.clienttype.application.dto.ClientTypePostDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service interface for Client Types.
 * Provides methods to manage client types.
 */
public interface ClientTypeService {
  Flux<ClientTypeDto> getAllClientTypes();
  
  Mono<ClientTypeDto> getClientTypeById(String id);
  
  Mono<ClientTypeDto> createClientType(ClientTypePostDto clientTypePostDto);
  
  Mono<ClientTypeDto> modifyClientType(String id, ClientTypePostDto clientTypePostDto);
  
  Mono<Void> deleteClientType(String id);
  
  Mono<Void> deleteAllClientTypes();
}
