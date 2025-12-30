package com.app.encuesta.mapper;

import com.app.encuesta.domain.Pregunta;
import com.app.encuesta.dto.PreguntaResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreguntaMapper {

    List<PreguntaResponseDto> toListDtos(List<Pregunta> preguntas);
}
