package com.bootcamp.client.client.infrastructure.persistence;

import com.bootcamp.client.client.domain.model.Client;
import com.bootcamp.client.client.domain.repositories.ClientRepository;
import com.bootcamp.client.client.infrastructure.dao.ClientDao;
import com.bootcamp.client.client.infrastructure.dao.ClientDaoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementation class of the ClientRepository interface.
 * It provides the implementation for managing the persistence of Client entities
 * using the ClientMongoRepository interface.
 */
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