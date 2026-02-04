package com.example.hogwarts.controller;

import com.example.hogwarts.dto.CasaDTO;
import com.example.hogwarts.service.CasaService;
import com.example.hogwarts.service.impl.CasaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/casa")
@RequiredArgsConstructor
public class CasaController {
    private CasaService casaService;

    @GetMapping
    public List<CasaDTO> obtenerCasas() {
        return casaService.obtenerTodasLasCasas();
    }
}
