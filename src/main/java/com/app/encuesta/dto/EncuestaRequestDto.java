package com.app.encuesta.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class EncuestaRequestDto implements Serializable {
    @NotBlank(message = "El titulo no puede ser vacio")
    private final String titulo;

    @NotBlank(message = "La descripcion no puede ser vacia")
    private final String descripcion;

    @NotNull(message = "La fecha de inicio no puede ser nula o vacia")
    private final LocalDate fechaInicio;

    @NotNull(message = "La fecha final no puede ser nula o vacia")
    private final LocalDate fechaFin;

    @AssertTrue(message = "La fecha de inicio debe ser anterior a la fecha de fin")
    public boolean isPeriodoValido(){
        if(fechaInicio == null || fechaFin == null){
            return true;
        }
        return fechaInicio.isBefore(fechaFin);
    }
}