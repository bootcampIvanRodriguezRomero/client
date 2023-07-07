package com.bootcamp.client.infraestructure.repository;
import com.bootcamp.client.infraestructure.repository.dao.ClientDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
public interface ClientRepository extends ReactiveMongoRepository<ClientDao,String> {
}
