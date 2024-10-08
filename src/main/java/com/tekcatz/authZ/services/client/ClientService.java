package com.tekcatz.authZ.services.client;

import com.tekcatz.authZ.controllers.client.dto.ClientCreateRequest;
import com.tekcatz.authZ.model.ClientEntity;
import com.tekcatz.authZ.repository.client.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void createClient(ClientCreateRequest clientCreateRequest) {
        ClientEntity client = ClientEntity.builder()
                .name(clientCreateRequest.getClientName())
                .grantTypes(clientCreateRequest.getGrant_types())
                .defaultScopes(clientCreateRequest.getDefaultScopes())
                .build();
        clientRepository.save(client);
        log.info("Client {} is saved", client.getClient_id());
    }
}
