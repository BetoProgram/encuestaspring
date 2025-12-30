package com.app.encuesta.service;

import com.app.encuesta.dto.EncuestaRequestDto;
import com.app.encuesta.dto.EncuestaResponseDto;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {
    List<EncuestaResponseDto> obtenerEncuestas();
    Optional<EncuestaResponseDto> obtenerEncuesta(int id);
    void guardar(EncuestaRequestDto encuestaRequestDto);
    void actualizar(int id, EncuestaRequestDto encuestaRequestDto);
    void deleteById(int id);
}
