package com.example.hogwarts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDTO {
    private Long idProfesor;
    private String nombreProfesor;
    private String nombreAsignatura;
    private LocalDate fechaInicio;
}
