package com.app.encuesta.mapper;

import com.app.encuesta.domain.Encuesta;
import com.app.encuesta.dto.EncuestaRequestDto;
import com.app.encuesta.dto.EncuestaResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EncuestaMapper {
    EncuestaResponseDto toDto(Encuesta encuesta);
    Encuesta toEntity(EncuestaRequestDto encuestaRequestDto);

    List<EncuestaResponseDto> toListDto(List<Encuesta> encuestas);
}
