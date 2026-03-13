package net.fiction.environmentmonitoring.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.unitmeasurement.UnitMeasurementDTORequest;
import net.fiction.environmentmonitoring.dto.unitmeasurement.UnitMeasurementDTOResponse;
import net.fiction.environmentmonitoring.service.UnitMeasurementService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
@RequiredArgsConstructor
public class UnitMeasurementController {

    private final UnitMeasurementService unitMeasurementService;

    @PostMapping
    public UnitMeasurementDTOResponse save(@Valid @RequestBody UnitMeasurementDTORequest unitDto){
        return unitMeasurementService.save(unitDto);
    }

    @GetMapping
    public List<UnitMeasurementDTOResponse> listAll(){
        return unitMeasurementService.listAll();
    }

    @GetMapping("/{id}")
    public UnitMeasurementDTOResponse listById(@PathVariable Long id){
        return unitMeasurementService.listById(id);
    }

    @PutMapping("/{id}")
    public UnitMeasurementDTOResponse updateById(@PathVariable Long id, @Valid @RequestBody UnitMeasurementDTORequest unitDto) {
        return unitMeasurementService.updateById(id, unitDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            unitMeasurementService.deleteById(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
        }
    }

}
