package net.fiction.environmentmonitoring.mapper;

import net.fiction.environmentmonitoring.dto.unitmeasurement.UnitMeasurementDTORequest;
import net.fiction.environmentmonitoring.dto.unitmeasurement.UnitMeasurementDTOResponse;
import net.fiction.environmentmonitoring.model.UnitMeasurement;
import org.springframework.stereotype.Component;

@Component
public class UnitMeasurementMapper {

    public UnitMeasurement toEntity(
            UnitMeasurementDTORequest unitMeasurementDto
    ){
        return new UnitMeasurement(
                unitMeasurementDto.nameMagnitude(),
                unitMeasurementDto.nameUnit()
        );
    }

    public UnitMeasurementDTOResponse toDto(
            UnitMeasurement unitMeasurement
    ){
        return new UnitMeasurementDTOResponse(
                unitMeasurement.getId(),
                unitMeasurement.getNameMagnitude(),
                unitMeasurement.getNameUnit()
        );
    }
}
