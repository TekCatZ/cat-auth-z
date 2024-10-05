package com.tekcatz.authZ.controllers.client.dto;

import com.tekcatz.authZ.commons.GrantType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClientCreateRequest {

    @NotNull
    private String clientName;

    @NotNull
    @NotEmpty(message = "grant types must not be empty")
    private List<GrantType> grant_types;

    private String defaultScopes;
}
