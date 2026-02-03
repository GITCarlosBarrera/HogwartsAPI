package com.example.hogwarts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EstudianteAsignaturaKey implements Serializable {
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "id_asignatura")
    private Integer idAsignatura;
}
