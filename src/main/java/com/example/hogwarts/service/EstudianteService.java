package com.example.hogwarts.service;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;

import java.util.List;

public interface EstudianteService {
    public List<EstudianteDTO> obtenerTodosLosEstudiantes();
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto);
}
