package com.app.encuesta.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_pregunta", schema = "dbo")
public class TipoPregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "tinyint not null")
    private Short id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;


}