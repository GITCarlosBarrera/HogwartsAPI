package com.example.hogwarts.controller;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.service.AsignaturaService;
import com.example.hogwarts.service.impl.AsignaturaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asignatura")
@RequiredArgsConstructor
public class AsignaturaController {
    private AsignaturaService asignaturaService;

    @GetMapping
    public List<AsignaturaDTO> obtenerAsignaturas() {
        return asignaturaService.obtenerTodasLasAsignaturas();
    }
}