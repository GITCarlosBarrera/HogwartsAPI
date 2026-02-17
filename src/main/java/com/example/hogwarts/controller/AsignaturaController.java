package com.example.hogwarts.controller;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.service.AsignaturaService;
import com.example.hogwarts.service.impl.AsignaturaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignatura")
@RequiredArgsConstructor
public class AsignaturaController {
    private final AsignaturaService asignaturaService;

    @GetMapping
    @Operation(summary = "Obten todas las asignaturas")
    public List<AsignaturaDTO> obtenerAsignaturas() {
        return asignaturaService.obtenerTodasLasAsignaturas();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una asignatura por su ID")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}