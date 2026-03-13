package net.fiction.environmentmonitoring.service;

import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTORequest;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTOResponse;
import net.fiction.environmentmonitoring.dto.unitmeasurement.UnitMeasurementDTORequest;
import net.fiction.environmentmonitoring.dto.unitmeasurement.UnitMeasurementDTOResponse;
import net.fiction.environmentmonitoring.mapper.UnitMeasurementMapper;
import net.fiction.environmentmonitoring.model.UnitMeasurement;
import net.fiction.environmentmonitoring.repository.UnitMeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitMeasurementService {

    private final UnitMeasurementRepository unitRepository;
    private final UnitMeasurementMapper unitMapper;

    public UnitMeasurementDTOResponse save(UnitMeasurementDTORequest unitDto){
        UnitMeasurement unit = unitMapper.toEntity(unitDto);

        return unitMapper.toDto(
                unitRepository.save(unit)
        );
    }
    public List<UnitMeasurementDTOResponse> listAll(){

        return unitRepository.findAll()
                .stream()
                .map(unitMapper::toDto)
                .toList();
    }
    public UnitMeasurementDTOResponse listById(Long id){


        return unitMapper.toDto(
                unitRepository.findById(id)
                        .orElseThrow( () -> new RuntimeException("Unidade de medida não encontrada"))
        );
    }
    public UnitMeasurementDTOResponse updateById(Long id, UnitMeasurementDTORequest unitDto){

        UnitMeasurement unitSaved = unitRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Unidade de medida não encontrada"));

        unitSaved.setNameUnit(unitDto.nameUnit());
        unitSaved.setNameMagnitude(unitDto.nameMagnitude());

        return unitMapper.toDto(unitRepository.save(unitSaved));

    }
    public void deleteById(Long id){
        unitRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Unidade de medida não encontrada"));

        unitRepository.deleteById(id);
    }
}
