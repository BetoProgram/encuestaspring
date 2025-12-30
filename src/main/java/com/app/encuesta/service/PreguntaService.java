package com.app.encuesta.service;

import com.app.encuesta.dto.PreguntaRequestDto;
import com.app.encuesta.dto.PreguntaResponseDto;
import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    List<PreguntaResponseDto> obtenerPreguntas();
    Optional<PreguntaResponseDto> obtenerPregunta(int id);
    void guardar(PreguntaRequestDto pregRequestDto);
    void actualizar(int id, PreguntaRequestDto pregRequestDto);
    void deleteById(int id);
}
