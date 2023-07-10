package com.bootcamp.client.infraestructure.rest;

import com.bootcamp.client.infraestructure.repository.ClientRepository;
import com.bootcamp.client.infraestructure.repository.dao.ClientDao;
import com.bootcamp.client.infraestructure.rest.dto.Client;
import com.bootcamp.client.infraestructure.rest.dto.ClientPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor

public class ClientResource {
    private final ClientRepository clientRepository;
    private static final Logger logger = LoggerFactory.getLogger(ClientResource.class);

    @GetMapping
    public Flux<Client> getAll() {
        return clientRepository.findAll()
                .map(this::fromClientDaoToClientDto);
    }
    @GetMapping("/{id}")
    public Mono<Client> findClientById(@PathVariable String id) {
        return clientRepository.findById(id)
                .map(this::fromClientDaoToClientDto);
    }
    @PostMapping
    public Mono<Client> createClient(@Valid @RequestBody ClientPost client) {
        ClientDao clientDao = fromClientPostToClientDao(client);
        return clientRepository.save(clientDao)
                .map(this::fromClientDaoToClientDto);
    }
    @PutMapping("/{id}")
    public Mono<Client> modifyClient(@PathVariable String id, @Valid @RequestBody Client client) {
        return  clientRepository.findById(id)
                .flatMap(existingClient -> {
                    existingClient.setDocumentType(client.getDocumentType());
                    existingClient.setDocumentNumber(client.getDocumentNumber());
                    existingClient.setFullName(client.getFullName());
                    existingClient.setEmail(client.getEmail());
                    existingClient.setType(client.getType());
                    return clientRepository.save(existingClient);
                })
                .map(this::fromClientDaoToClientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        logger.info("Deleting client with ID: {}", id);
        clientRepository.deleteById(id);
        logger.info("Client deleted successfully");
    }
    @DeleteMapping
    public void deleteAllClients() {
        logger.info("Deleting all clients");
        clientRepository.deleteAll();
        logger.info("All clients deleted successfully");
    }
    private Client fromClientDaoToClientDto(ClientDao dao) {
        Client client = new Client();
        client.setId(dao.getId());
        client.setDocumentNumber(dao.getDocumentNumber());
        client.setDocumentType(dao.getDocumentType());
        client.setFullName(dao.getFullName());
        client.setEmail(dao.getEmail());
        client.setType(dao.getType());
        return client;
    }

    private ClientDao fromClientPostToClientDao(ClientPost clientPost) {
        ClientDao client = new ClientDao();
        client.setId(UUID.randomUUID().toString());
        client.setDocumentType(clientPost.getDocumentType());
        client.setDocumentNumber(clientPost.getDocumentNumber());
        client.setFullName(clientPost.getFullName());
        client.setEmail(clientPost.getEmail());
        client.setType(clientPost.getType());
        return client;
    }
}
