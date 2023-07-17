package com.bootcamp.client.clienttype.domain.repositories;

import com.bootcamp.client.clienttype.domain.model.ClientType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for managing client types.
 * Provides methods for retrieving, creating, modifying, and deleting client types.
 */
public interface ClientTypeRepository {
  Flux<ClientType> findAll();
  
  Mono<ClientType> findById(String id);
  
  Mono<Boolean> existsByName(String name);
  
  Mono<ClientType> findByName(String name);
  
  Mono<ClientType> save(ClientType clientType);
  
  Mono<Void> deleteById(String id);
  
  Mono<Void> deleteAll();
}
