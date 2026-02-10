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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "nombre")
    private String nombreEstudiante;

    @Column(name = "apellido")
    private String apellidoEstudiante;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @Column(name = "anyo_curso")
    private Long anyoCursoEstudiante;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimientoEstudiante;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteAsignatura> calificaciones;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Mascota mascota;
}
