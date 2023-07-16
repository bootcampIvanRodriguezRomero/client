package com.bootcamp.client.client.infrastructure.persistence;

import com.bootcamp.client.client.domain.model.Client;
import com.bootcamp.client.client.domain.repositories.ClientRepository;
import com.bootcamp.client.client.infrastructure.dao.ClientDaoConverter;
import com.bootcamp.client.client.infrastructure.dao.ClientDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientMongoRepository clientMongoRepository;

    @Override
    public Flux<Client> findAll() {
        return clientMongoRepository.findAll()
                .map(ClientDaoConverter.INSTANCE::clientDaoToClient);
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientMongoRepository.findById(id)
                .map(ClientDaoConverter.INSTANCE::clientDaoToClient);
    }

    @Override
    public Mono<Client> save(Client client) {
        ClientDao clientDao = ClientDaoConverter.INSTANCE.clientToClientDao(client);
        return clientMongoRepository.save(clientDao)
                .map(ClientDaoConverter.INSTANCE::clientDaoToClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clientMongoRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return clientMongoRepository.deleteAll();
    }
}