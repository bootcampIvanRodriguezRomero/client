package com.bootcamp.client.client.domain.repositories;

import com.bootcamp.client.client.domain.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for managing clients.
 */
public interface ClientRepository {
  Flux<Client> findAll();
  
  Mono<Client> findById(String id);
  
  Mono<Client> save(Client client);
  
  Mono<Void> deleteById(String id);
  
  Mono<Void> deleteAll();
}
