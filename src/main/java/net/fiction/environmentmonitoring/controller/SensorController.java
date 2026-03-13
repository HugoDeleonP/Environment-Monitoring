package net.fiction.environmentmonitoring.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTORequest;
import net.fiction.environmentmonitoring.dto.sensor.SensorDTOResponse;
import net.fiction.environmentmonitoring.service.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public SensorDTOResponse save(@Valid @RequestBody SensorDTORequest sensorDTO){
        return sensorService.save(sensorDTO);
    }

    @GetMapping
    public List<SensorDTOResponse> listAll(){
        return sensorService.listAll();
    }

    @GetMapping("/{id}")
    public SensorDTOResponse listById(@PathVariable Long id){
        return sensorService.listById(id);
    }

    @PutMapping("/{id}")
    public SensorDTOResponse updateById(@PathVariable Long id, @Valid @RequestBody SensorDTORequest sensorDTO){
        return sensorService.updateById(id, sensorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        try{
            sensorService.deleteById(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        }catch (RuntimeException e){
            return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
        }

    }


}
