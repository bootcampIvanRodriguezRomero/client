package com.bootcamp.client.client.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = PersonalClientData.class, name = "personalClientData"),
  @JsonSubTypes.Type(value = BusinessClientData.class, name = "businessClientData"),
})
public interface ClientData {
}
