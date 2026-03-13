package net.fiction.environmentmonitoring.dto.log;

import java.time.LocalDateTime;

public record LogDTOResponse(
        Long id,
        Double value,
        LocalDateTime dateHour,
        String roomName,
        String unitName
) {
}