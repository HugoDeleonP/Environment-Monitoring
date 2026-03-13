package net.fiction.environmentmonitoring.mapper;

import net.fiction.environmentmonitoring.dto.sensor.SensorDTORequest;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTOResponse;
import net.fiction.environmentmonitoring.model.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {

    public Sensor toEntity(SensorDTORequest sensorDto){
        return new Sensor(
                sensorDto.model(),
                sensorDto.manufacturer(),
                sensorDto.supplyVoltage()
        );
    }

    public SensorDTOResponse toDto(Sensor sensor){
        return new SensorDTOResponse(
                sensor.getId(),
                sensor.getModel(),
                sensor.getManufacturer(),
                sensor.getSupplyVoltage()
        );
    }
}
