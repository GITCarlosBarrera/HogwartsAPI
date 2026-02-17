package com.example.hogwarts.controller;

import com.example.hogwarts.dto.AsignaturaCalificacionDTO;
import com.example.hogwarts.service.AsignaturaCalificacionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturacalificacion")
@RequiredArgsConstructor
public class AsignaturaCalificacionController {
    private final AsignaturaCalificacionService asignaturaCalificacionService;

    @GetMapping
    @Operation(summary = "Obten todas las calificaciones")
    public List<AsignaturaCalificacionDTO> obtenerCalificaciones() {
        return asignaturaCalificacionService.obtenerTodasLasCalificaciones();
    }
}
