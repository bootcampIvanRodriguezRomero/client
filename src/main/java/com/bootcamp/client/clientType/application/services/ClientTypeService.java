package com.bootcamp.client.clientType.application.services;

import com.bootcamp.client.clientType.application.dto.ClientTypeDto;
import com.bootcamp.client.clientType.application.dto.ClientTypePostDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientTypeService {
    Flux<ClientTypeDto> getAllClientTypes();
    Mono<ClientTypeDto> getClientTypeById(String id);
    Mono<ClientTypeDto> createClientType(ClientTypePostDto clientTypePostDto);
    Mono<ClientTypeDto> modifyClientType(String id, ClientTypePostDto clientTypePostDto);
    Mono<Void> deleteClientType(String id);
    Mono<Void> deleteAllClientTypes();
}
