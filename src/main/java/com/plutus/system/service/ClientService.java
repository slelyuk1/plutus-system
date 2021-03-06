package com.plutus.system.service;

import com.plutus.system.model.entity.Client;
import com.plutus.system.model.request.client.CreateClientRequest;
import com.plutus.system.model.request.client.FindClientRequest;

import java.util.Collection;
import java.util.Optional;

public interface ClientService {
    Client create(CreateClientRequest request);

    Optional<Client> findClient(FindClientRequest request);

    // todo add search request
    Collection<Client> getAllClients();
}
