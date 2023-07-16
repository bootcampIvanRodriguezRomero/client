package com.bootcamp.client.clientType.application.services;

import com.bootcamp.client.clientType.application.dto.ClientTypeDtoConverter;
import com.bootcamp.client.clientType.application.dto.ClientTypePostDto;
import com.bootcamp.client.clientType.application.dto.ClientTypePostDtoConverter;
import com.bootcamp.client.clientType.domain.model.ClientType;
import com.bootcamp.client.clientType.application.dto.ClientTypeDto;
import com.bootcamp.client.clientType.domain.repositories.ClientTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientTypeServiceImpl implements ClientTypeService {

    private final ClientTypeRepository clientTypeRepository;

    @Override
    public Flux<ClientTypeDto> getAllClientTypes() {
        return clientTypeRepository.findAll()
                .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
    }

    @Override
    public Mono<ClientTypeDto> getClientTypeById(String id) {
        return clientTypeRepository.findById(id)
                .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
    }

    @Override
    public Mono<ClientTypeDto> createClientType(ClientTypePostDto clientTypePostDto) {
        return clientTypeRepository.existsByName(clientTypePostDto.getName())
                .flatMap(nameExists -> {
                    if(nameExists) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name already exists"));
                    } else {
                        ClientType clientType = ClientTypePostDtoConverter.INSTANCE.clientTypePostDtoToClientType(clientTypePostDto);
                        return clientTypeRepository.save(clientType)
                                .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
                    }
                });
    }

    @Override
    public Mono<ClientTypeDto> modifyClientType(String id, ClientTypePostDto clientTypePostDto) {
        return  clientTypeRepository.existsByName(clientTypePostDto.getName())
                .flatMap(nameExists -> {
                    if(nameExists) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name already exists"));
                    } else {
                        return clientTypeRepository.findById(id)
                                .flatMap(clientType -> {
                                    ClientType modifiedClientType = ClientTypePostDtoConverter.INSTANCE.clientTypePostDtoToClientType(clientTypePostDto);
                                    modifiedClientType.setId(clientType.getId());
                                    return clientTypeRepository.save(modifiedClientType);
                                })
                                .map(ClientTypeDtoConverter.INSTANCE::clientTypeToClientTypeDto);
                    }
                });
    }

    @Override
    public Mono<Void> deleteClientType(String id) {

        return clientTypeRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAllClientTypes() {

        return clientTypeRepository.deleteAll();
    }

}
