package com.bootcamp.client.client.infrastructure.persistence;

import com.bootcamp.client.client.infrastructure.dao.ClientDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * ReactiveMongoRepository interface for managing the persistence of ClientDao entities.
 * It provides CRUD operations and reactive query execution for ClientDao objects.
 */
public interface ClientMongoRepository extends ReactiveMongoRepository<ClientDao, String> {
}
