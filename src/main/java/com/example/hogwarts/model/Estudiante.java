package com.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_estudiante")
    private int idEstudiante;

    @Column(name = "nombre")
    private String nombreEstudiante;

    @Column(name = "apellido")
    private String apellidoEstudiante;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @Column(name = "anyo_curso")
    private int anyoCursoEstudiante;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimientoEstudiante;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteAsignatura> calificaciones;

    @OneToOne(mappedBy = "estudiante")
    private Mascota mascota;
}
