package net.fiction.environmentmonitoring.mapper;

import net.fiction.environmentmonitoring.dto.log.LogDTORequest;
import net.fiction.environmentmonitoring.dto.log.LogDTOResponse;
import net.fiction.environmentmonitoring.model.Log;
import net.fiction.environmentmonitoring.model.Room;
import net.fiction.environmentmonitoring.model.UnitMeasurement;
import org.springframework.stereotype.Component;

@Component
public class LogMapper {

    public Log toEntity(
            LogDTORequest logDto, Room room, UnitMeasurement unitMeasurement
    ){
        return new Log(
                logDto.value(),
                room,
                unitMeasurement
        );
    }

    public LogDTOResponse toDto(
            Log log
    ){
        return new LogDTOResponse(
                log.getId(),
                log.getValue(),
                log.getDateHour(),
                log.getRoom().getName(),
                log.getUnitMeasurement().getNameUnit()
        );
    }
}
