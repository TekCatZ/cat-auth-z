package com.tekcatz.authZ.controllers.client;

import com.tekcatz.authZ.controllers.client.dto.ClientCreateRequest;
import com.tekcatz.authZ.controllers.client.dto.ClientCreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @PostMapping
    public ClientCreateResponse create(
            @Valid ClientCreateRequest request
            ) {

        return null;
    }
}
