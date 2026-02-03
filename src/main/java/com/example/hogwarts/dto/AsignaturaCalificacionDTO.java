package com.example.hogwarts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaCalificacionDTO {
    private String asignatura;
    private double calificacion;
}
