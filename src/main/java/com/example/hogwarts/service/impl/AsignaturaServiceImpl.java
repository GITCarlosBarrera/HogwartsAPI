package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.mapper.AsignaturaMapper;
import com.example.hogwarts.model.Asignatura;
import com.example.hogwarts.repository.AsignaturaRepository;
import com.example.hogwarts.repository.ProfesorRepository;
import com.example.hogwarts.service.AsignaturaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {
    private AsignaturaRepository asignaturaRepository;
    private AsignaturaMapper asignaturaMapper;

    @Override
    public List<AsignaturaDTO> obtenerTodasLasAsignaturas() {
        List<Asignatura> lista = asignaturaRepository.findAll();

        return lista.stream()
                .map(asignaturaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void eliminarAsignatura(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("La asignatura con ID " + id + "no existe"));

        if (!asignatura.getCalificaciones().isEmpty()) throw new IllegalStateException("No se puede borrar una asignatura con estudiantes asignados");

        asignaturaRepository.delete(asignatura);
    }
}