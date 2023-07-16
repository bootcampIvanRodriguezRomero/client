package com.bootcamp.client.client.application.services;

import com.bootcamp.client.client.application.dto.ClientDto;
import com.bootcamp.client.client.domain.model.Client;
import com.bootcamp.client.client.domain.repositories.ClientRepository;
import com.bootcamp.client.client.infrastructure.converter.ClientConverter;
import com.bootcamp.client.client.application.dto.ClientPostDto;
import com.bootcamp.client.clientType.domain.repositories.ClientTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientTypeRepository clientTypeRepository;

    @Override
    public Flux<ClientDto> getAllClients() {
        return clientRepository.findAll()
                .map(ClientConverter.INSTANCE::clientToClientDto);
    }

    @Override
    public Mono<ClientDto> getClientById(String id) {
        return clientRepository.findById(id)
                .map(ClientConverter.INSTANCE::clientToClientDto);
    }

    @Override
    public Mono<ClientDto> createClient(ClientPostDto clientPostDto) {
        return clientTypeRepository.findByName(clientPostDto.getType())
                .flatMap(clientType -> {
                    Client client = ClientConverter.INSTANCE.clientPostDtoToClient(clientPostDto);
                    client.setType(clientType);
                    return clientRepository.save(client)
                            .map(ClientConverter.INSTANCE::clientToClientDto);
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The client type does not exist")));
    }

    @Override
    public Mono<ClientDto> modifyClient(String id, ClientPostDto clientPostDto) {
        return clientTypeRepository.findByName(clientPostDto.getType())
                .flatMap(clientType ->
                        clientRepository.findById(id)
                                .flatMap(client -> {
                                    Client modifiedClient = ClientConverter.INSTANCE.clientPostDtoToClient(clientPostDto);
                                    modifiedClient.setId(client.getId());
                                    modifiedClient.setType(clientType);
                                    return clientRepository.save(modifiedClient);
                                })
                                .map(ClientConverter.INSTANCE::clientToClientDto))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The client type does not exist")));
    }

    @Override
    public Mono<Void> deleteClient(String id) {
       return clientRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAllClients() {

        return clientRepository.deleteAll();
    }

}
