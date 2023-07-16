package com.bootcamp.client.client.application.services;

import com.bootcamp.client.client.application.dto.ClientDto;
import com.bootcamp.client.client.domain.model.Client;
import com.bootcamp.client.client.domain.repositories.ClientRepository;
import com.bootcamp.client.client.application.dto.ClientDtoConverter;
import com.bootcamp.client.client.application.dto.ClientPostDtoConverter;
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
                .map(ClientDtoConverter.INSTANCE::clientToClientDto);
    }

    @Override
    public Mono<ClientDto> getClientById(String id) {
        return clientRepository.findById(id)
                .map(ClientDtoConverter.INSTANCE::clientToClientDto);
    }

    @Override
    public Mono<ClientDto> createClient(ClientPostDto clientPostDto) {
        return clientTypeRepository.findByName(clientPostDto.getType())
                .flatMap(clientType -> {
                    Client client = ClientPostDtoConverter.INSTANCE.clientPostDtoToClient(clientPostDto);
                    client.setType(clientType);
                    return clientRepository.save(client)
                            .map(ClientDtoConverter.INSTANCE::clientToClientDto);
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The client type does not exist")));
    }

    @Override
    public Mono<ClientDto> modifyClient(String id, ClientPostDto clientPostDto) {
        return clientTypeRepository.findByName(clientPostDto.getType())
                .flatMap(clientType ->
                        clientRepository.findById(id)
                                .flatMap(client -> {
                                    Client modifiedClient = ClientPostDtoConverter.INSTANCE.clientPostDtoToClient(clientPostDto);
                                    modifiedClient.setId(client.getId());
                                    modifiedClient.setType(clientType);
                                    return clientRepository.save(modifiedClient);
                                })
                                .map(ClientDtoConverter.INSTANCE::clientToClientDto))
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
