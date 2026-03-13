package net.fiction.environmentmonitoring.service;

import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.log.LogDTORequest;
import net.fiction.environmentmonitoring.dto.log.LogDTOResponse;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTORequest;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTOResponse;
import net.fiction.environmentmonitoring.mapper.LogMapper;
import net.fiction.environmentmonitoring.model.Log;
import net.fiction.environmentmonitoring.model.Room;
import net.fiction.environmentmonitoring.model.UnitMeasurement;
import net.fiction.environmentmonitoring.repository.LogRepository;
import net.fiction.environmentmonitoring.repository.RoomRepository;
import net.fiction.environmentmonitoring.repository.UnitMeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;
    private final RoomRepository roomRepository;
    private final UnitMeasurementRepository unitRepository;
    private final LogMapper logMapper;

    public LogDTOResponse save(LogDTORequest logDto) {

        Room room = roomRepository.findById(logDto.roomId())
                .orElseThrow( () -> new RuntimeException("Cômodo não encontrado"));

        UnitMeasurement unitMeasurement = unitRepository.findById(logDto.unitId())
                .orElseThrow( () -> new RuntimeException("Unidade de medida não encontrada"));

        Log log = logMapper.toEntity(logDto, room, unitMeasurement);

        return logMapper.toDto(logRepository.save(log));

    }

    public List<LogDTOResponse> listAll() {

        return logRepository.findAll()
                .stream()
                .map( logMapper::toDto)
                .toList();

    }

    public LogDTOResponse listById(Long id) {

        return logMapper.toDto(
                logRepository.findById(id)
                        .orElseThrow( () -> new RuntimeException("Registro não encontrado"))
        );
    }

    public LogDTOResponse updateById(Long id, LogDTORequest logDto){

        Log logSaved = logRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Registro não encontrado"));

        logSaved.setValue(logDto.value());

        logSaved.setRoom(
                roomRepository.findById(logDto.roomId())
                        .orElseThrow( () -> new RuntimeException("Cômodo não encontrado"))
        );

        logSaved.setUnitMeasurement(
                unitRepository.findById(logDto.unitId())
                        .orElseThrow( () -> new RuntimeException("Unidade de medida não encontrada"))
        );

        return logMapper.toDto(logRepository.save(logSaved));

    }

    public void deleteById(Long id){

        logRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Registro não encontrado"));

        logRepository.deleteById(id);

    }

}
