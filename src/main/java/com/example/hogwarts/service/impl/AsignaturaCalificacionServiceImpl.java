package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.AsignaturaCalificacionDTO;
import com.example.hogwarts.mapper.AsignaturaCalificacionMapper;
import com.example.hogwarts.model.EstudianteAsignatura;
import com.example.hogwarts.repository.AsignaturaCalificacionRepository;
import com.example.hogwarts.service.AsignaturaCalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignaturaCalificacionServiceImpl implements AsignaturaCalificacionService {
    private final AsignaturaCalificacionRepository asignaturaCalificacionRepository;
    private final AsignaturaCalificacionMapper asignaturaCalificacionMapper;

    @Override
    public List<AsignaturaCalificacionDTO> obtenerTodasLasCalificaciones() {
        List<EstudianteAsignatura> lista = asignaturaCalificacionRepository.findAll();

        return lista.stream()
                .map(asignaturaCalificacionMapper::toDto)
                .toList();
    }
}
