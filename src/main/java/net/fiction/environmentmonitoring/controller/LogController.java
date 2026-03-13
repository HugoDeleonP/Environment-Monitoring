package net.fiction.environmentmonitoring.controller;

import lombok.RequiredArgsConstructor;
import net.fiction.environmentmonitoring.dto.log.LogDTORequest;
import net.fiction.environmentmonitoring.dto.log.LogDTOResponse;
import net.fiction.environmentmonitoring.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public LogDTOResponse save(@RequestBody LogDTORequest logDto) {
        return logService.save(logDto);
    }

    @GetMapping
    public List<LogDTOResponse> listAll() {
        return logService.listAll();
    }

    @GetMapping("/{id}")
    public LogDTOResponse listById(@PathVariable Long id) {
        return logService.listById(id);
    }

    @PutMapping("/{id}")
    public LogDTOResponse updateById(@PathVariable Long id, @RequestBody LogDTORequest logDto){
        return logService.updateById(id, logDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
           try {
               logService.deleteById(id);
               return ResponseEntity.ok("Deletado com sucesso!");
           }catch (RuntimeException e){
               return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
           }
    }
}
