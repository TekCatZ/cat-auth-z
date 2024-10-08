package com.tekcatz.authZ.controllers.client;

import com.tekcatz.authZ.controllers.client.dto.ClientCreateRequest;
import com.tekcatz.authZ.controllers.client.dto.ClientCreateResponse;
import com.tekcatz.authZ.services.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientCreateResponse create(
            @Valid @RequestBody
            ClientCreateRequest request
            ) {
        clientService.createClient(request);
        return null;
    }
}
