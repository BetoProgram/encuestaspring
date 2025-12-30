package com.app.encuesta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class TipoPreguntaDto implements Serializable {
    private final Short id;
    private final String nombre;
}