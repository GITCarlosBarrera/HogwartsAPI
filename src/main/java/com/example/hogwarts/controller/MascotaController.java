package com.example.hogwarts.controller;

import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.dto.create.MascotaCreateDTO;
import com.example.hogwarts.service.MascotaService;
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
    private MascotaService mascotaService;

    @GetMapping
    public List<MascotaDTO> obtenerMascotas() {
        return mascotaService.obtenerTodasLasMascotas();
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> crearMascota(@Valid @RequestBody MascotaCreateDTO dto) {
        MascotaDTO mascotaCreado = mascotaService.crearMascota(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaCreado); // 201 Created
    }
}
