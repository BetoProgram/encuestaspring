package com.app.encuesta.controller;

import com.app.encuesta.dto.EncuestaRequestDto;
import com.app.encuesta.dto.EncuestaResponseDto;
import com.app.encuesta.service.EncuestaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encuestas")
@AllArgsConstructor
public class EncuestasController {
    private EncuestaService encuestaService;

    @GetMapping
    public ResponseEntity<List<EncuestaResponseDto>> get(){
        var encuestas = encuestaService.obtenerEncuestas();
        return ResponseEntity.ok(encuestas);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EncuestaRequestDto encuesta){
        encuestaService.guardar(encuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(encuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncuestaResponseDto> getById(@PathVariable int id){
        var encuesta = encuestaService.obtenerEncuesta(id);
        return ResponseEntity.ok(encuesta.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,  @Valid @RequestBody EncuestaRequestDto encuesta){
        encuestaService.actualizar(id, encuesta);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable int id){
        encuestaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
