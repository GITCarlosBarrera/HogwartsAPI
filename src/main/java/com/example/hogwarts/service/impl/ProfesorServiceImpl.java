package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.mapper.ProfesorMapper;
import com.example.hogwarts.model.Profesor;
import com.example.hogwarts.repository.ProfesorRepository;
import com.example.hogwarts.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {
    private ProfesorRepository profesorRepository;
    private ProfesorMapper profesorMapper;

    @Override
    public List<ProfesorDTO> obtenerTodosLosProfesores() {
        List<Profesor> lista = profesorRepository.findAll();

        return lista.stream()
                .map(profesorMapper::toDto)
                .toList();
    }
}
