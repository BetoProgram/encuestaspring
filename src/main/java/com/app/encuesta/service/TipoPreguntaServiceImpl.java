package com.app.encuesta.service;

import com.app.encuesta.domain.TipoPregunta;
import com.app.encuesta.dto.TipoPreguntaDto;
import com.app.encuesta.mapper.TipoPreguntaMapper;
import com.app.encuesta.repository.TipoPreguntaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoPreguntaServiceImpl implements TipoPreguntaService {

    private final TipoPreguntaRepository tipoPreguntaRepository;
    private final TipoPreguntaMapper tipoPreguntaMapper;

    @Override
    public List<TipoPreguntaDto> obtenerTipoPreguntas() {
        List<TipoPregunta> tipoPreguntas = tipoPreguntaRepository.findAll();
        return tipoPreguntaMapper.toListDtos(tipoPreguntas);
    }
}
