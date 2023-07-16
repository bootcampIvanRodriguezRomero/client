package com.bootcamp.client.client.application.services;

import com.bootcamp.client.client.application.dto.ClientDto;
import com.bootcamp.client.client.application.dto.ClientPostDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<ClientDto> getAllClients();
    Mono<ClientDto> getClientById(String id);
    Mono<ClientDto> createClient(ClientPostDto clientPostDto);
    Mono<ClientDto> modifyClient(String id, ClientPostDto clientPostDto);
    Mono<Void> deleteClient(String id);
    Mono<Void> deleteAllClients();
}
