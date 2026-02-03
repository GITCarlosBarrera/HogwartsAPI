package com.example.hogwarts.controller;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.service.impl.EstudianteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@RequiredArgsConstructor
public class EstudianteController {
    private EstudianteServiceImpl estudianteService;

    @GetMapping
    public List<EstudianteDTO> obtenerEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }
}
