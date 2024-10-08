package com.tekcatz.authZ.controllers.client.dto;

import com.tekcatz.authZ.commons.GrantType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateRequest {

    @NotNull
    private String clientName;

    @NotNull
    @NotEmpty(message = "grant types must not be empty")
    private List<GrantType> grant_types;

    private String defaultScopes;
}
