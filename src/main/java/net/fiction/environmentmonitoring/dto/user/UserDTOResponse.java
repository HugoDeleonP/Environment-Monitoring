package net.fiction.environmentmonitoring.dto.user;

public record UserDTOResponse(
        Long id,
        String fullName,
        String email,
        String password
) {
}
