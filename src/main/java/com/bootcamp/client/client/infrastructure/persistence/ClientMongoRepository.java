package com.bootcamp.client.client.infrastructure.persistence;
import com.bootcamp.client.client.infrastructure.dao.ClientDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
public interface ClientMongoRepository extends ReactiveMongoRepository<ClientDao,String> {
}
