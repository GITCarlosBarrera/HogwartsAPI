package com.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_mascota")
    private Integer idMascota;

    @Column(name = "nombre")
    private String nombreMascota;

    @Column(name = "especie")
    private String especieMascota;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
}
