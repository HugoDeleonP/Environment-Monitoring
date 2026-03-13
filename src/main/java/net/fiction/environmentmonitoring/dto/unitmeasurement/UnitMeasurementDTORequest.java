package net.fiction.environmentmonitoring.dto.unitmeasurement;

import jakarta.validation.constraints.NotBlank;

public record UnitMeasurementDTORequest(

        @NotBlank
        String nameMagnitude,

        @NotBlank
        String nameUnit
) {
}