package com.tekcatz.authZ.model;

import com.tekcatz.authZ.commons.GrantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    private String name;

    @ElementCollection(targetClass = GrantType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "grant_type", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)  // Store enum as string in the join table
    @Column(name = "grant_types")
    private List<GrantType> grantTypes;

    @Column(name = "default_scopes")
    private String defaultScopes;
}
