package com.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_profesor")
    private Integer idProfesor;

    @Column(name = "nombre")
    private String nombreProfesor;

    @Column(name = "apellido")
    private String apellidoProfesor;

    @OneToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicioProfesor;

    @OneToOne(mappedBy = "profesor")
    private Casa casa;
}
