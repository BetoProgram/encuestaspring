package com.app.encuesta.service;

import com.app.encuesta.domain.Pregunta;
import com.app.encuesta.dto.PreguntaRequestDto;
import com.app.encuesta.dto.PreguntaResponseDto;
import com.app.encuesta.exception.ResourceNotFoundException;
import com.app.encuesta.mapper.PreguntaMapper;
import com.app.encuesta.mapper.TipoPreguntaRepository;
import com.app.encuesta.repository.EncuestaRepository;
import com.app.encuesta.repository.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final EncuestaRepository encuestaRepository;
    private final TipoPreguntaRepository tipoPreguntaRepository;
    private final PreguntaMapper preguntaMapper;

    @Override
    public List<PreguntaResponseDto> obtenerPreguntas() {
        var preguntas = preguntaRepository.findAll();
        return preguntaMapper.toListDtos(preguntas);
    }

    @Override
    public Optional<PreguntaResponseDto> obtenerPregunta(int id) {
        return Optional.empty();
    }

    @Override
    public void guardar(PreguntaRequestDto pregRequestDto) {
        var encuesta =encuestaRepository.findById(pregRequestDto.getEncuestaId())
                .orElseThrow(()
                        -> new ResourceNotFoundException("La encuesta "+ pregRequestDto.getEncuestaId() +" no se encuestra registrada"));

        var tipoPregunta = tipoPreguntaRepository.findById(pregRequestDto.getTipoPreguntaId())
                .orElseThrow(() -> new ResourceNotFoundException("El tipo de pregunta no se encuestra registrado"));

        Pregunta pregunta = new Pregunta();
        pregunta.setTitulo(pregRequestDto.getTitulo());
        pregunta.setTipoPregunta(tipoPregunta);
        pregunta.setEncuesta(encuesta);

        preguntaRepository.save(pregunta);
    }

    @Override
    public void actualizar(int id, PreguntaRequestDto pregRequestDto) {

    }

    @Override
    public void deleteById(int id) {

    }
}
