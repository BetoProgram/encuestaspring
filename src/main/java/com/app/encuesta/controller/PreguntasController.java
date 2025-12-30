package com.app.encuesta.controller;

import com.app.encuesta.dto.PreguntaRequestDto;
import com.app.encuesta.dto.PreguntaResponseDto;
import com.app.encuesta.dto.TipoPreguntaDto;
import com.app.encuesta.service.PreguntaService;
import com.app.encuesta.service.TipoPreguntaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/preguntas")
@RequiredArgsConstructor
public class PreguntasController {
    private final PreguntaService preguntaService;
    private final TipoPreguntaService tipoPreguntaService;

    @GetMapping
    public ResponseEntity<List<PreguntaResponseDto>> get(){
        return ResponseEntity.ok(preguntaService.obtenerPreguntas());
    }

    @GetMapping("/tipopreguntas")
    public ResponseEntity<List<TipoPreguntaDto>> tipopreguntas(){
        return ResponseEntity.ok(tipoPreguntaService.obtenerTipoPreguntas());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PreguntaRequestDto preguntaRequestDto){
        preguntaService.guardar(preguntaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(preguntaRequestDto);
    }
}
