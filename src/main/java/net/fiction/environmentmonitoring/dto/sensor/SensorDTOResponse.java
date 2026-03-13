package net.fiction.environmentmonitoring.dto.sensor;

public record SensorDTOResponse(
        Long id,
        String model,
        String manufacturer,
        Double supplyVoltage
) {
}
