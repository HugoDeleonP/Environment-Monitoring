package net.fiction.environmentmonitoring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.room.RoomDTORequest;
import net.fiction.environmentmonitoring.dto.room.RoomDTOResponse;
import net.fiction.environmentmonitoring.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public RoomDTOResponse save( @Valid @RequestBody RoomDTORequest roomDto){

        return roomService.save(roomDto);
    }

    @GetMapping
    public List<RoomDTOResponse> listAll(){
        return roomService.listAll();
    }

    @GetMapping("/{id}")
    public RoomDTOResponse listById(@PathVariable Long id){
        return roomService.listById(id);
    }

    @PutMapping("/{id}")
    public RoomDTOResponse updateById(@PathVariable Long id, @Valid @RequestBody RoomDTORequest roomDto){
        return roomService.updateById(id, roomDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            roomService.deleteById(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        }catch (RuntimeException e){
            return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
        }
    }




}
