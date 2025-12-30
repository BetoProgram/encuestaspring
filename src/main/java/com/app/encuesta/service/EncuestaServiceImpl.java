package com.app.encuesta.service;

import com.app.encuesta.domain.Encuesta;
import com.app.encuesta.dto.EncuestaRequestDto;
import com.app.encuesta.dto.EncuestaResponseDto;
import com.app.encuesta.exception.ResourceNotFoundException;
import com.app.encuesta.mapper.EncuestaMapper;
import com.app.encuesta.repository.EncuestaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EncuestaServiceImpl implements EncuestaService {

    private final EncuestaRepository encuestaRepository;
    private final EncuestaMapper encuestaMapper;

    @Override
    public List<EncuestaResponseDto> obtenerEncuestas() {
        List<Encuesta> encuestasDb = encuestaRepository.findAll();
        List<EncuestaResponseDto> encuestas = encuestaMapper.toListDto(encuestasDb);
        return encuestas;
    }

    @Override
    public Optional<EncuestaResponseDto> obtenerEncuesta(int id) {
        var encuesta = encuestaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("La encuesta "+ id +" no se encuetra registrada")
        );
        return Optional.ofNullable(encuestaMapper.toDto(encuesta));
    }

    @Override
    @Transactional
    public void guardar(EncuestaRequestDto encuestaRequestDto) {
        Encuesta encuesta = encuestaMapper.toEntity(encuestaRequestDto);
        encuestaRepository.save(encuesta);
    }

    @Override
    @Transactional
    public void actualizar(int id, EncuestaRequestDto encuestaRequestDto) {
        var encuestasDb = encuestaRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("La encuesta "+ id +" no se encuetra registrada")
        );

        encuestasDb.setTitulo(encuestaRequestDto.getTitulo());
        encuestasDb.setDescripcion(encuestaRequestDto.getDescripcion());
        encuestasDb.setFechaInicio(encuestaRequestDto.getFechaInicio());
        encuestasDb.setFechaFin(encuestaRequestDto.getFechaFin());

        encuestaRepository.save(encuestasDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if(!encuestaRepository.existsById(id)){
            throw new ResourceNotFoundException("La encuesta "+ id +" no se encuetra registrada");
        }

        encuestaRepository.deleteById(id);
    }
}
