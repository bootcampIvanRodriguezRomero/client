package com.bootcamp.client.client.infrastructure.rest;

import com.bootcamp.client.client.application.dto.ClientDto;
import com.bootcamp.client.client.application.dto.ClientPostDto;
import com.bootcamp.client.client.application.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientResource {

    private final ClientService clientService;
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientDto> getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientDto> createClient(@Valid @RequestBody ClientPostDto clientPostDto) {
        return clientService.createClient(clientPostDto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientDto> modifyClient(@PathVariable String id, @Valid @RequestBody ClientPostDto clientPostDto) {
        return clientService.modifyClient(id, clientPostDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteClient(@PathVariable String id) {
        return clientService.deleteClient(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAllClients() {
        return clientService.deleteAllClients();
    }
}
