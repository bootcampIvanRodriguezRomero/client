package com.bootcamp.client.clienttype.infrastructure.rest;

import com.bootcamp.client.clienttype.application.dto.ClientTypeDto;
import com.bootcamp.client.clienttype.application.dto.ClientTypePostDto;
import com.bootcamp.client.clienttype.application.services.ClientTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing client types. This class defines the API endpoints
 * for performing CRUD operations
 * on client types. It handles incoming HTTP requests and delegates the processing
 * to the corresponding methods
 * in the ClientTypeService.
 */
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
  public Mono<ClientTypeDto> createClientType(
      @Valid @RequestBody ClientTypePostDto clientTypePostDto) {
    return clientTypeService.createClientType(clientTypePostDto);
  }
  
  @PutMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Mono<ClientTypeDto> modifyClientType(@PathVariable String id, @Valid @RequestBody
      ClientTypePostDto clientTypePostDto) {
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
