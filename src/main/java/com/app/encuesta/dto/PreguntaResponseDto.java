package com.app.encuesta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class PreguntaResponseDto implements Serializable {
    private final Integer id;
    private final String titulo;
    private final TipoPreguntaDto tipoPregunta;
    private final EncuestaResponseDto encuesta;
}