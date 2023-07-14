package com.bootcamp.client.infraestructure.rest;

import com.bootcamp.client.infraestructure.repository.ClientRepository;
import com.bootcamp.client.infraestructure.repository.ClientTypeRepository;
import com.bootcamp.client.infraestructure.repository.dao.ClientDao;
import com.bootcamp.client.infraestructure.rest.dto.ClientDto;
import com.bootcamp.client.infraestructure.rest.dto.ClientPostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientResource {
    private final ClientRepository clientRepository;
    private final ClientTypeRepository clientTypeRepository;
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClientDto> getAll() {
        return clientRepository.findAll()
                .map(this::fromClientDaoToClientDto);
    }
    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientDto> findClientById(@PathVariable String id) {
        return clientRepository.findById(id)
                .map(this::fromClientDaoToClientDto);
    }
    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientDto> createClient(@Valid @RequestBody ClientPostDto clientPostDto) {
        return clientTypeRepository.findByName(clientPostDto.getType())
            .flatMap(clientTypeDao -> {
                    ClientDao clientDao = fromClientPostDtoToClientDao(clientPostDto);
                    clientDao.setType(clientTypeDao);
                    return clientRepository.save(clientDao)
                            .map(this::fromClientDaoToClientDto);

            })
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The client type does not exist")));

    }
    @PutMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ClientDto> modifyClient(@PathVariable String id, @Valid @RequestBody ClientPostDto clientPostDto) {
        return clientTypeRepository.findByName(clientPostDto.getType())
                .flatMap(clientTypeDao ->
                    clientRepository.findById(id)
                                    .flatMap(existingClient -> {
                                        existingClient.setDocumentType(clientPostDto.getDocumentType());
                                        existingClient.setDocumentNumber(clientPostDto.getDocumentNumber());
                                        existingClient.setFullName(clientPostDto.getFullName());
                                        existingClient.setEmail(clientPostDto.getEmail());
                                        existingClient.setType(clientTypeDao);
                                        return clientRepository.save(existingClient);
                                    })
                                    .map(this::fromClientDaoToClientDto)
                )
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The client type does not exist")));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        log.info("Deleting client with ID: {}", id);
        clientRepository.deleteById(id);
        log.info("Client deleted successfully");
    }
    @DeleteMapping
    public void deleteAllClients() {
        log.info("Deleting all clients");
        clientRepository.deleteAll();
        log.info("All clients deleted successfully");
    }
    private ClientDto fromClientDaoToClientDto(ClientDao clientDao) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(clientDao.getId());
        clientDto.setDocumentNumber(clientDao.getDocumentNumber());
        clientDto.setDocumentType(clientDao.getDocumentType());
        clientDto.setFullName(clientDao.getFullName());
        clientDto.setEmail(clientDao.getEmail());
        clientDto.setType(clientDao.getType());
        return clientDto;
    }
    private ClientDao fromClientPostDtoToClientDao(ClientPostDto clientPostDto) {
        ClientDao clientDao = new ClientDao();
        clientDao.setId(UUID.randomUUID().toString());
        clientDao.setDocumentType(clientPostDto.getDocumentType());
        clientDao.setDocumentNumber(clientPostDto.getDocumentNumber());
        clientDao.setFullName(clientPostDto.getFullName());
        clientDao.setEmail(clientPostDto.getEmail());
        return clientDao;
    }
}
