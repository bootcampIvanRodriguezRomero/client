package com.bootcamp.client.clienttype.infrastructure.persistence;

import com.bootcamp.client.clienttype.infrastructure.dao.ClientTypeDao;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * ReactiveMongoRepository interface for performing CRUD operations on ClientTypeDao entities.
 * This interface extends ReactiveMongoRepository and provides additional query methods.
 */
public interface ClientTypeMongoRepository extends ReactiveMongoRepository<ClientTypeDao, String> {
  @Query(value = "{'name':?0}", exists = true)
  Mono<Boolean> existsByName(String name);
  
  @Query(value = "{'name': ?0}")
  Mono<ClientTypeDao> findByName(String name);
}
