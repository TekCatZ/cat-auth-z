package com.tekcatz.authZ.controllers.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientCreateResponse {
    private String clientId;
    private String clientSecret;
    private List<String> allowedScopes;
    private List<String> defaultScopes;
}
