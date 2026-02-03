package com.example.hogwarts.controller;

import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
