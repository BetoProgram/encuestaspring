package com.app.encuesta.service;

import com.app.encuesta.dto.TipoPreguntaDto;

import java.util.List;

public interface TipoPreguntaService {
    List<TipoPreguntaDto> obtenerTipoPreguntas();
}
