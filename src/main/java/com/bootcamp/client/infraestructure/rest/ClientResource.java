package com.bootcamp.client.infraestructure.rest;

import com.bootcamp.client.infraestructure.repository.ClientRepository;
import com.bootcamp.client.infraestructure.repository.dao.ClientDao;
import com.bootcamp.client.infraestructure.rest.dto.Client;
import com.bootcamp.client.infraestructure.rest.dto.ClientPost;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientResource {
    private final ClientRepository clientRepository;

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
    public Mono<Client> createClient(@RequestBody ClientPost client) {
        return clientRepository.save(this.fromClientPostToClientDao(client))
                .map(this::fromClientDaoToClientDto);
    }

    @PutMapping
    public Client modifyClient(@RequestBody Client client) {
        return  null;
    }

    @DeleteMapping
    public void deleteClient(@PathVariable String id) {
        // nada
    }

    private Client fromClientDaoToClientDto(ClientDao dao) {
        Client client = new Client();
        client.setId(dao.getId());
        client.setDocumentNumber(dao.getDocumentNumber());
        client.setDocumentType(dao.getDocumentType());
        client.setFullName(dao.getFullName());
        return client;
    }

    private ClientDao fromClientPostToClientDao(ClientPost clientPost) {
        ClientDao client = new ClientDao();
        client.setFullName(clientPost.getFullName());
        client.setDocumentType(clientPost.getDocumentType());
        client.setDocumentNumber(clientPost.getDocumentNumber());
        return client;
    }
}
