package com.example.hogwarts.controller;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.update.EstudianteUpdateDTO;
import com.example.hogwarts.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@RequiredArgsConstructor
public class EstudianteController {
    private final EstudianteService estudianteService;

    @GetMapping
    @Operation(summary = "Obten todas los estudiantes")
    public List<EstudianteDTO> obtenerEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }

    @PostMapping
    @Operation(summary = "Crea un nuevo estudiante")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteCreateDTO dto) {
        EstudianteDTO estudianteCreado = estudianteService.crearEstudiante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado); // 201 Created
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica los datos de un estudiante")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody EstudianteUpdateDTO dto) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, dto);
        return ResponseEntity.ok(estudianteActualizado); // 200 OK
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un estudiante por su ID")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
