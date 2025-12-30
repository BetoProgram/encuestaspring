package com.app.encuesta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class PreguntaRequestDto implements Serializable {
    @NotBlank(message = "El titulo no puede ser vacio")
    private final String titulo;

    @NotNull(message = "La encuesta no puede ser nula")
    private final Integer encuestaId;

    @NotNull(message = "El tipo de pregunta no puede ser nula")
    private final Short tipoPreguntaId;
}