package net.fiction.environmentmonitoring.service;

import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.room.RoomDTORequest;
import net.fiction.environmentmonitoring.dto.room.RoomDTOResponse;
import net.fiction.environmentmonitoring.mapper.RoomMapper;
import net.fiction.environmentmonitoring.model.Room;
import net.fiction.environmentmonitoring.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomDTOResponse save(RoomDTORequest roomDto){

        Room room = roomMapper.toEntity(roomDto);

        return roomMapper.toDto(
                roomRepository.save(room)
        );

    }

    public List<RoomDTOResponse> listAll(){

        List<Room> rooms = roomRepository.findAll();

        return rooms.stream()
                .map(room -> roomMapper.toDto(room))
                .toList();
    }

    public RoomDTOResponse listById(Long id){



        return roomMapper.toDto(
                roomRepository.findById(id)
                        .orElseThrow( () -> new RuntimeException("Cômodo não encontrado"))
        );
    }

    public RoomDTOResponse updateById(Long id, RoomDTORequest roomDto){

        Room roomSaved = roomRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Cômodo não encontrado"));

        roomSaved.setName(roomDto.name());
        roomSaved.setFloor(roomDto.floor());

        return roomMapper.toDto(
                roomRepository.save(roomSaved)
        );
    }

    public void deleteById(Long id){

        roomRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Cômodo não encontrado"));

        roomRepository.deleteById(id);
    }



}