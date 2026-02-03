package com.example.hogwarts.service;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.update.EstudianteUpdateDTO;

import java.util.List;

public interface EstudianteService {
    public List<EstudianteDTO> obtenerTodosLosEstudiantes();
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto);
    public EstudianteDTO actualizarEstudiante(Integer id, EstudianteUpdateDTO dto);
}
