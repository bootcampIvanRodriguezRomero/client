package com.bootcamp.client.clientType.domain.repositories;

import com.bootcamp.client.clientType.domain.model.ClientType;
import com.bootcamp.client.clientType.infrastructure.dao.ClientTypeDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientTypeRepository {
    Flux<ClientType> findAll();
    Mono<ClientType> findById(String id);
    Mono<Boolean> existsByName(String name);
    Mono<ClientType> findByName(String name);
    Mono<ClientType> save(ClientType clientType);
    Mono<Void> deleteById(String id);
    Mono<Void> deleteAll();
}
