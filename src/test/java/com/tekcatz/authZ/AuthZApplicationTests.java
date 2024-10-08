package com.tekcatz.authZ;

import com.tekcatz.authZ.commons.GrantType;
import com.tekcatz.authZ.controllers.client.dto.ClientCreateRequest;
import com.tekcatz.authZ.repository.client.ClientRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AuthZApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void beforeQuery() {
        clientRepository.deleteAll();
    }

    @Test
    public void shouldCreateClient() throws Exception {
        ClientCreateRequest req = getClientRequest();
        String reqString = objectMapper.writeValueAsString(req);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/client").with(csrf())
                        .with(user("bob").password("bobspassword").roles("USER","ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reqString))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1, clientRepository.findAll().size());
    }
    private ClientCreateRequest getClientRequest() {
        List<GrantType> grantTypeList = new ArrayList<>();
        grantTypeList.add(GrantType.AUTHORIZATION_CODE);
        return ClientCreateRequest.builder().clientName("Vinh Doan").grant_types(grantTypeList).defaultScopes("").build();
    }
}
