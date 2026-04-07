package net.fiction.environmentmonitoring.dto.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDTOResponse(
        int status,
        String message,
        String error,
        LocalDateTime timestamp
) {
}
