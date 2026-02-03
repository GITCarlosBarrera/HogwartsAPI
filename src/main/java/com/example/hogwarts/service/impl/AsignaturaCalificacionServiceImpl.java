package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.AsignaturaCalificacionDTO;
import com.example.hogwarts.mapper.AsignaturaCalificacionMapper;
import com.example.hogwarts.model.EstudianteAsignatura;
import com.example.hogwarts.model.EstudianteAsignaturaKey;
import com.example.hogwarts.repository.AsignaturaCalificacionRepository;

import java.util.List;

public class AsignaturaCalificacionServiceImpl {
    private AsignaturaCalificacionRepository asignaturaCalificacionRepository;

    @Override
    public List<AsignaturaCalificacionDTO> obtenerTodasLasCalificaciones() {
        List<EstudianteAsignatura> lista = asignaturaCalificacionRepository.findAll();

        return lista.stream()
                .map(AsignaturaCalificacionMapper::toDTO)
                .toList();
    }
}
