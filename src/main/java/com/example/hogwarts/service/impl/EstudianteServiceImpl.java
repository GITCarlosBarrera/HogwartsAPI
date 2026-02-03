package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.mapper.EstudianteMapper;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.repository.EstudianteRepository;
import com.example.hogwarts.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private EstudianteRepository estudianteRepository;

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> lista = estudianteRepository.findAll();

        return lista.stream()
                .map(EstudianteMapper::toDTO)
                .toList();
    }
}
