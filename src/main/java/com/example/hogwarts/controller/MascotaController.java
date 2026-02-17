package com.example.hogwarts.controller;

import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.dto.create.MascotaCreateDTO;
import com.example.hogwarts.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
@RequiredArgsConstructor
public class MascotaController {
    private final MascotaService mascotaService;

    @GetMapping
    public List<MascotaDTO> obtenerMascotas() {
        return mascotaService.obtenerTodasLasMascotas();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mascota creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la mascota")
    })
    @PostMapping
    @Operation(summary = "Obten todas las mascotas")
    public ResponseEntity<MascotaDTO> crearMascota(@Valid @RequestBody MascotaCreateDTO dto) {
        MascotaDTO mascotaCreado = mascotaService.crearMascota(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaCreado); // 201 Created
    }
}
