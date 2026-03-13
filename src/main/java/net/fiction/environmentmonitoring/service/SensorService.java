package net.fiction.environmentmonitoring.service;

import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTORequest;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTOResponse;
import net.fiction.environmentmonitoring.mapper.SensorMapper;
import net.fiction.environmentmonitoring.model.Sensor;
import net.fiction.environmentmonitoring.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public SensorDTOResponse save(SensorDTORequest sensorDto){
        Sensor sensor = sensorMapper.toEntity(sensorDto);

        return sensorMapper.toDto(
                sensorRepository.save(sensor)
        );

    }

    public List<SensorDTOResponse> listAll(){

        List<Sensor> sensors = sensorRepository.findAll();

        return sensors
                .stream()
                .map(sensorMapper::toDto)
                .toList();
    }

    public SensorDTOResponse listById(Long id){


        return sensorMapper.toDto(
                sensorRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Sensor não encontrado"))
        );
    }

    public SensorDTOResponse updateById(Long id, SensorDTORequest sensorDto){

        Sensor sensorSaved = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));

        sensorSaved.setModel(sensorDto.model());
        sensorSaved.setManufacturer(sensorDto.manufacturer());
        sensorSaved.setSupplyVoltage(sensorDto.supplyVoltage());

        return sensorMapper.toDto(sensorRepository.save(sensorSaved));
    }

    public void deleteById(Long id){

        sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));

        sensorRepository.deleteById(id);

    }



}
