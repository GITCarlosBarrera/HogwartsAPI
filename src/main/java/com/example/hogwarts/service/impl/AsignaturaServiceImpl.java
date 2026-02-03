package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.mapper.AsignaturaMapper;
import com.example.hogwarts.model.Asignatura;
import com.example.hogwarts.repository.AsignaturaRepository;
import com.example.hogwarts.service.AsignaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<AsignaturaDTO> obtenerTodasLasAsignaturas() {
        List<Asignatura> lista = asignaturaRepository.findAll();

        return lista.stream()
                .map(AsignaturaMapper::toDTO)
                .collect(Collectors.toList());
    }
}