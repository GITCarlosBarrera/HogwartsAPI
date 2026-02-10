package com.example.hogwarts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CasaDTO {
    private Long idCasa;
    private String nombreCasa;
    private String fundador;
    private String fantasma;
    private ProfesorDTO jefe;
    private List<String> estudiantes;
}
