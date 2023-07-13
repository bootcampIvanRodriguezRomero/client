package com.bootcamp.client.infraestructure.repository;
import com.bootcamp.client.infraestructure.repository.dao.ClientTypeDao;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientTypeRepository extends ReactiveMongoRepository<ClientTypeDao, String> {
    @Query(value = "{'name':?0}", exists = true)
    Mono<Boolean> existsByName(String name);
    @Query(value = "{'name': ?0}")
    Mono<ClientTypeDao> findByName(String name);
}
