package net.fiction.environmentmonitoring.dto.room;

import jakarta.validation.constraints.NotBlank;

public record RoomDTORequest(

        @NotBlank
        String name,

        @NotBlank
        String floor
) {
}
