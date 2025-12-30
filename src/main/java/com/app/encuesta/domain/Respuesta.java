package com.app.encuesta.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "respuesta", schema = "dbo")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    @Column(name = "respuesta_texto", length = 500)
    private String respuestaTexto;

    @ColumnDefault("getdate()")
    @Column(name = "fecha_respuesta", nullable = false)
    private Instant fechaRespuesta;


}