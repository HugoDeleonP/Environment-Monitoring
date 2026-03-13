package net.fiction.environmentmonitoring.service;

import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTORequest;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTOResponse;
import net.fiction.environmentmonitoring.dto.user.UserDTORequest;
import net.fiction.environmentmonitoring.dto.user.UserDTOResponse;
import net.fiction.environmentmonitoring.mapper.UserMapper;
import net.fiction.environmentmonitoring.model.User;
import net.fiction.environmentmonitoring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


    public UserDTOResponse save(UserDTORequest userDto) {

        User user = userMapper.toEntity(userDto);

        return userMapper.toDto(userRepository.save(user));
    }

    public List<UserDTOResponse> listAll() {

        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDTOResponse listById(Long id){


        return userMapper.toDto(
                userRepository.findById(id)
                        .orElseThrow( () -> new RuntimeException("Usuário não encontrado"))
        );
    }

    public UserDTOResponse updateById(Long id, UserDTORequest userDto) {

        User userSaved = userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não encontrado"));

        userSaved.setFullName(userDto.fullName());
        userSaved.setEmail(userDto.email());
        userSaved.setPassword(userDto.password());

        return userMapper.toDto(userRepository.save(userSaved));

    }

    public void deleteById(Long id){

        userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não encontrado"));

        userRepository.deleteById(id);

    }


}