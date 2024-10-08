package com.tekcatz.authZ.commons.exceptions;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
//@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ApiException extends RuntimeException {
    private String id;
    private String message;
    private List<String> details;
}
