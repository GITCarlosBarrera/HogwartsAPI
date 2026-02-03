package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.AsignaturaCalificacionDTO;
import com.example.hogwarts.mapper.AsignaturaCalificacionMapper;
import com.example.hogwarts.model.EstudianteAsignatura;
import com.example.hogwarts.repository.AsignaturaCalificacionRepository;
import com.example.hogwarts.service.AsignaturaCalificacionService;

import java.util.List;

public class AsignaturaCalificacionServiceImpl implements AsignaturaCalificacionService {
    private AsignaturaCalificacionRepository asignaturaCalificacionRepository;
    private AsignaturaCalificacionMapper asignaturaCalificacionMapper;

    @Override
    public List<AsignaturaCalificacionDTO> obtenerTodasLasCalificaciones() {
        List<EstudianteAsignatura> lista = asignaturaCalificacionRepository.findAll();

        return lista.stream()
                .map(asignaturaCalificacionMapper::toDto)
                .toList();
    }
}
