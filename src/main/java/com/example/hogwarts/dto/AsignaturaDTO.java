package com.example.hogwarts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO {
    private Long idAsignatura;
    private String nombreAsignatura;
    private String aula;
    private Boolean asignaturaObligatoria;
    private String profesor;
}