package com.bootcamp.client.clientType.infrastructure.persistence;

import com.bootcamp.client.clientType.domain.model.ClientType;
import com.bootcamp.client.clientType.domain.repositories.ClientTypeRepository;
import com.bootcamp.client.clientType.infrastructure.converter.ClientTypeConverter;
import com.bootcamp.client.clientType.infrastructure.dao.ClientTypeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ClientTypeRepositoryImpl implements ClientTypeRepository {

    private final ClientTypeMongoRepository clientTypeMongoRepository;

    @Override
    public Flux<ClientType> findAll() {
        return clientTypeMongoRepository.findAll()
                .map(ClientTypeConverter.INSTANCE::clientTypeDaoToClientType);
    }

    @Override
    public Mono<ClientType> findById(String id) {
        return clientTypeMongoRepository.findById(id)
                .map(ClientTypeConverter.INSTANCE::clientTypeDaoToClientType);
    }

    @Override
    public Mono<Boolean> existsByName(String name) {
        return clientTypeMongoRepository.existsByName(name);
    }

    @Override
    public Mono<ClientType> findByName(String name) {
        return clientTypeMongoRepository.findByName(name)
                .map(ClientTypeConverter.INSTANCE::clientTypeDaoToClientType);
    }

    @Override
    public Mono<ClientType> save(ClientType clientType) {
        ClientTypeDao clientTypeDao = ClientTypeConverter.INSTANCE.clientTypeToClientTypeDao(clientType);
        return clientTypeMongoRepository.save(clientTypeDao)
                .map(ClientTypeConverter.INSTANCE::clientTypeDaoToClientType);
    }

    @Override
    public Mono<Void> deleteById(String id) {

        return clientTypeMongoRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {

        return clientTypeMongoRepository.deleteAll();
    }
}
