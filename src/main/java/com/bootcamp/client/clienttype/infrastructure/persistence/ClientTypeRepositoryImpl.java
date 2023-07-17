package com.bootcamp.client.clienttype.infrastructure.persistence;

import com.bootcamp.client.clienttype.domain.model.ClientType;
import com.bootcamp.client.clienttype.domain.repositories.ClientTypeRepository;
import com.bootcamp.client.clienttype.infrastructure.dao.ClientTypeDao;
import com.bootcamp.client.clienttype.infrastructure.dao.ClientTypeDaoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementation of the ClientTypeRepository interface that provides the persistence
 * operations for managing client types using MongoDB as the underlying data source.
 * This class interacts with the ClientTypeMongoRepository to perform CRUD operations.
 */
@Repository
@RequiredArgsConstructor
public class ClientTypeRepositoryImpl implements ClientTypeRepository {
  
  private final ClientTypeMongoRepository clientTypeMongoRepository;
  
  @Override
  public Flux<ClientType> findAll() {
    return clientTypeMongoRepository.findAll()
      .map(ClientTypeDaoConverter.INSTANCE::clientTypeDaoToClientType);
  }
  
  @Override
  public Mono<ClientType> findById(String id) {
    return clientTypeMongoRepository.findById(id)
      .map(ClientTypeDaoConverter.INSTANCE::clientTypeDaoToClientType);
  }
  
  @Override
  public Mono<Boolean> existsByName(String name) {
    return clientTypeMongoRepository.existsByName(name);
  }
  
  @Override
  public Mono<ClientType> findByName(String name) {
    return clientTypeMongoRepository.findByName(name)
      .map(ClientTypeDaoConverter.INSTANCE::clientTypeDaoToClientType);
  }
  
  @Override
  public Mono<ClientType> save(ClientType clientType) {
    ClientTypeDao clientTypeDao =
        ClientTypeDaoConverter.INSTANCE.clientTypeToClientTypeDao(clientType);
    return clientTypeMongoRepository.save(clientTypeDao)
      .map(ClientTypeDaoConverter.INSTANCE::clientTypeDaoToClientType);
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
