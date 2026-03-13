package net.fiction.environmentmonitoring.dto.sensor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record SensorDTORequest(
        @NotBlank
        String model,

        @NotBlank
        String manufacturer,

        @NotNull
        @PositiveOrZero
        Double supplyVoltage
) {
}
