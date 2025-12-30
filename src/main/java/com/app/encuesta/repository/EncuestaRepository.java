package com.app.encuesta.repository;

import com.app.encuesta.domain.Encuesta;
import com.app.encuesta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {

}