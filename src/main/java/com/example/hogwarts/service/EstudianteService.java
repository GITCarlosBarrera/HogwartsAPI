package com.example.hogwarts.service;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.update.EstudianteUpdateDTO;

import java.util.List;

public interface EstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes();
    EstudianteDTO crearEstudiante(EstudianteCreateDTO dto);
    EstudianteDTO actualizarEstudiante(Long id, EstudianteUpdateDTO dto);
    void eliminarEstudiante(Long id);
}
