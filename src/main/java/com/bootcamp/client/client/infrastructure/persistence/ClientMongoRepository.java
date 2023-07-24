package com.bootcamp.client.client.infrastructure.persistence;

import com.bootcamp.client.client.domain.model.ClientData;
import com.bootcamp.client.client.infrastructure.dao.ClientDao;
import com.bootcamp.client.clienttype.domain.model.ClientType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * ReactiveMongoRepository interface for managing the persistence of ClientDao entities.
 * It provides CRUD operations and reactive query execution for ClientDao objects.
 */
public interface ClientMongoRepository extends ReactiveMongoRepository<ClientDao, String> {
  
}
