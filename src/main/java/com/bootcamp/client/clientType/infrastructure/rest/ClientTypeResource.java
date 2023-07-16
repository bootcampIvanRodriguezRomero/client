package com.bootcamp.client.clientType.infrastructure.rest;

import com.bootcamp.client.clientType.application.dto.ClientTypeDto;
import com.bootcamp.client.clientType.application.dto.ClientTypePostDto;
import com.bootcamp.client.clientType.application.services.ClientTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientTypes")
@RequiredArgsConstructor
public class ClientTypeResource {

    private final ClientTypeService clientTypeService;
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClientTypeDto> getAllClientTypes() {
        return clientTypeService.getAllClientTypes();
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientTypeDto> getClientTypeById(@PathVariable String id) {
        return clientTypeService.getClientTypeById(id);
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientTypeDto> createClientType(@Valid @RequestBody ClientTypePostDto clientTypePostDto) {
        return clientTypeService.createClientType(clientTypePostDto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientTypeDto> modifyClientType(@PathVariable String id, @Valid @RequestBody ClientTypePostDto clientTypePostDto) {
        return clientTypeService.modifyClientType(id, clientTypePostDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteClientType(@PathVariable String id) {

        return clientTypeService.deleteClientType(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAllClientTypes() {

        return clientTypeService.deleteAllClientTypes();
    }

}
