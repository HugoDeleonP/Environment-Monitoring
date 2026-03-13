package net.fiction.environmentmonitoring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.user.UserDTORequest;
import net.fiction.environmentmonitoring.dto.user.UserDTOResponse;
import net.fiction.environmentmonitoring.service.UserService;
import org.hibernate.annotations.processing.SQL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTOResponse save(@Valid @RequestBody UserDTORequest userDto) {

        return userService.save(userDto);
    }

    @GetMapping
    public List<UserDTOResponse> listAll() {

        return userService.listAll();
    }

    @GetMapping("/{id}")
    public UserDTOResponse listById(@PathVariable Long id) {

        return userService.listById(id);
    }

    @PutMapping("/{id}")
    public UserDTOResponse updateById(@PathVariable Long id, @Valid @RequestBody UserDTORequest userDto) {

        return userService.updateById(id, userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        try {
            userService.deleteById(id);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
        }

    }

}
