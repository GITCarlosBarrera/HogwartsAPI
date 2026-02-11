package com.example.hogwarts.controllers;

import com.example.hogwarts.controller.AsignaturaController;
import com.example.hogwarts.controller.EstudianteController;
import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.create.MascotaCreateDTO;
import com.example.hogwarts.model.Asignatura;
import com.example.hogwarts.service.AsignaturaService;
import com.example.hogwarts.service.EstudianteService;
import com.example.hogwarts.service.MascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstudianteController.class)
public class EstudianteRestController {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EstudianteService estudianteService;
    @MockitoBean
    private MascotaService mascotaService;
    @MockitoBean
    private AsignaturaService asignaturaService;

    @Autowired
    private ObjectMapper objectMapper;

    private EstudianteCreateDTO estudianteCreateDTO;
    private EstudianteDTO estudianteResponseDTO;

    @BeforeEach
    void setUp() {
        MascotaCreateDTO mascotaDTO = new MascotaCreateDTO();
        mascotaDTO.setNombre("mascota");
        mascotaDTO.setEspecie("especie");

        estudianteCreateDTO = new EstudianteCreateDTO();
        estudianteCreateDTO.setNombre("Harry");
        estudianteCreateDTO.setApellido("Potter");
        estudianteCreateDTO.setAnyoCurso(1L);
        estudianteCreateDTO.setFechaNacimiento(LocalDate.of(2003, 04, 12));
        estudianteCreateDTO.setIdCasa(1L);
        estudianteCreateDTO.setMascota(mascotaDTO);

        estudianteResponseDTO = new EstudianteDTO();
        estudianteResponseDTO.setId(1L);
        estudianteResponseDTO.setNombre("Harry");
    }

    @Test
    void crearEstudianteYMascota_Error() throws Exception {
        estudianteCreateDTO.setAnyoCurso(10L);

        mockMvc.perform(post("/api/estudiante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteCreateDTO)))
                .andExpect(status().isBadRequest());
    }
}
