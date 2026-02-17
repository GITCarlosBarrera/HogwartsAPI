package com.example.hogwarts.controller;

import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.service.ProfesorService;
import com.example.hogwarts.service.impl.ProfesorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService profesorService;

    @GetMapping
    @Operation(summary = "Obten todos los profesores")
    public List<ProfesorDTO> obtenerProfesores() {
        return profesorService.obtenerTodosLosProfesores();
    }
}
