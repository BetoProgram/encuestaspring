package com.app.encuesta.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pregunta", schema = "dbo")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo_pregunta", nullable = false)
    private TipoPregunta tipoPregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encuesta_id")
    private Encuesta encuesta;

    @OneToMany(mappedBy = "pregunta")
    private Set<Opcion> opcions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pregunta")
    private Set<Respuesta> respuestas = new LinkedHashSet<>();


}