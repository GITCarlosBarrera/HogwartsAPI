package com.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_casa")
    private int idCasa;

    @Column(name = "nombre")
    private String nombreCasa;

    @Column(name = "fundador")
    private String fundadorCasa;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    private Profesor profesor;

    @Column(name = "fantasma")
    private String fantasmaCasa;

    @OneToMany(mappedBy = "casa")
    private List<Estudiante> estudiantes;
}
