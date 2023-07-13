package com.bootcamp.client.infraestructure.rest;

import com.bootcamp.client.infraestructure.repository.ClientTypeRepository;
import com.bootcamp.client.infraestructure.repository.dao.ClientTypeDao;
import com.bootcamp.client.infraestructure.rest.dto.ClientTypeDto;
import com.bootcamp.client.infraestructure.rest.dto.ClientTypePostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/clientType")
@RequiredArgsConstructor
public class ClientTypeResource {
    private final ClientTypeRepository clientTypeRepository;
    @GetMapping
    public Flux<ClientTypeDto> getAllClientTypes() {
        return clientTypeRepository.findAll()
                .map(this::fromClientTypeDaoToClientTypeDto);
    }
    @PostMapping
    public Mono<ClientTypeDto> createClientType(@Valid @RequestBody ClientTypePostDto clientTypePostDto) {
        return clientTypeRepository.existsByName(clientTypePostDto.getName())
                .flatMap(nameExists -> {
                    if (nameExists) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name already exists"));
                    } else {
                        return clientTypeRepository.save(fromClientTypePostDtoToClientTypeDao(clientTypePostDto))
                                .map(this::fromClientTypeDaoToClientTypeDto);
                    }
                });
    }
    @GetMapping("/{id}")
    public Mono<ClientTypeDto> getClientTypeById(@PathVariable String id) {
        return clientTypeRepository.findById(id)
                .map(this::fromClientTypeDaoToClientTypeDto);
    }
    @PutMapping("/{id}")
    public Mono<ClientTypeDto> modifyClientTypeById(@PathVariable String id, @Valid @RequestBody ClientTypePostDto clientTypePostDto) {
        return  clientTypeRepository.existsByName(clientTypePostDto.getName())
                .flatMap(nameExists -> {
                    if(nameExists) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name already exists"));
                    } else {
                        return clientTypeRepository.findById(id)
                                .flatMap(existingClientType -> {
                                    existingClientType.setName(clientTypePostDto.getName());
                                    return clientTypeRepository.save(existingClientType);
                                })
                                .map(this::fromClientTypeDaoToClientTypeDto);
                    }
                });
    }
    @DeleteMapping("/{id}")
    public void deleteClientType(@PathVariable String id) {
        clientTypeRepository.deleteById(id);
    }
    @DeleteMapping
    public void deleteAllClientTypes() {
        clientTypeRepository.deleteAll();
    }
    private ClientTypeDto fromClientTypeDaoToClientTypeDto(ClientTypeDao clientTypeDao) {
        ClientTypeDto clientTypeDto = new ClientTypeDto();
        clientTypeDto.setId(clientTypeDao.getId());
        clientTypeDto.setName(clientTypeDao.getName());
        return clientTypeDto;
    }
    private ClientTypeDao fromClientTypePostDtoToClientTypeDao(ClientTypePostDto clientTypePostDto) {
        ClientTypeDao clientTypeDao = new ClientTypeDao();
        clientTypeDao.setId(UUID.randomUUID().toString());
        clientTypeDao.setName(clientTypePostDto.getName());
        return clientTypeDao;
    }
}
