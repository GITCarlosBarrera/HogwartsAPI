package com.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_asignatura")
    private Long idAsignatura;

    @Column(name = "nombre")
    private String nombreAsignatura;

    private String aula;

    @Column(name = "obligatoria")
    private boolean asignaturaObligatoria;

    @OneToOne(mappedBy = "asignatura")
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura")
    private List<EstudianteAsignatura> calificaciones;
}
