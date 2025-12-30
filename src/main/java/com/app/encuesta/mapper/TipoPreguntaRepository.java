package com.app.encuesta.mapper;

import com.app.encuesta.domain.TipoPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPreguntaRepository extends JpaRepository<TipoPregunta, Short> {
}