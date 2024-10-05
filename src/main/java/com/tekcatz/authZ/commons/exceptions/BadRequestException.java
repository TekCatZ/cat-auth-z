package com.tekcatz.authZ.commons.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class BadRequestException extends ApiException {
    BadRequestException(String id, String message, List<String> details) {
        super(id, message, details);
    }
}
