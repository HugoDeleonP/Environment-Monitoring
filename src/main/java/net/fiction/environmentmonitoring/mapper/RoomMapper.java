package net.fiction.environmentmonitoring.mapper;

import net.fiction.environmentmonitoring.dto.room.RoomDTORequest;
import net.fiction.environmentmonitoring.dto.room.RoomDTOResponse;
import net.fiction.environmentmonitoring.model.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public Room toEntity(RoomDTORequest roomDTO){
        return new Room(roomDTO.name(), roomDTO.floor());
    }

    public RoomDTOResponse toDto(Room room){
        return new RoomDTOResponse(
                room.getId(),
                room.getName(),
                room.getFloor()
        );
    }
}
