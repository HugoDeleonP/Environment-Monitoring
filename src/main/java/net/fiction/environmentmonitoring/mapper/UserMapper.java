package net.fiction.environmentmonitoring.mapper;

import net.fiction.environmentmonitoring.dto.user.UserDTORequest;
import net.fiction.environmentmonitoring.dto.user.UserDTOResponse;
import net.fiction.environmentmonitoring.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(
            UserDTORequest userDto
    ){
        return new User(
                userDto.fullName(),
                userDto.email(),
                userDto.password()
        );
    }

    public UserDTOResponse toDto(
            User user
    ){
        return new UserDTOResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
