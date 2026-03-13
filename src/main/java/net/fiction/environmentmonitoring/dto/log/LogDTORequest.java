package net.fiction.environmentmonitoring.dto.log;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record LogDTORequest(


        @NotNull
        Double value,

        @Positive
        @NotNull
        Long roomId,

        @Positive
        @NotNull
        Long unitId
) {
}
