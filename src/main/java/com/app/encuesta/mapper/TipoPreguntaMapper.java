package com.app.encuesta.mapper;

import com.app.encuesta.domain.TipoPregunta;
import com.app.encuesta.dto.TipoPreguntaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoPreguntaMapper {
    List<TipoPreguntaDto> toListDtos(List<TipoPregunta> tipoPreguntas);
}
