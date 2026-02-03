package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.mapper.EstudianteMapper;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.repository.CasaRepository;
import com.example.hogwarts.repository.EstudianteRepository;
import com.example.hogwarts.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private CasaRepository casaRepository;
    private EstudianteRepository estudianteRepository;
    private EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> lista = estudianteRepository.findAll();

        return lista.stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }

    @Override
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto, casaRepository);
    }
}
