package com.example.hogwarts.controllers;

import com.example.hogwarts.controller.AsignaturaController;
import com.example.hogwarts.service.AsignaturaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AsignaturaController.class)
public class AsignaturaRestController {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AsignaturaService asignaturaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void eliminarAsignatura_ConEstudiantes_Error() throws Exception {
        doThrow(new IllegalStateException("No se puede eliminar una asignatura con estudiantes"))
                .when(asignaturaService).eliminarAsignatura(1L);

        mockMvc.perform(delete("/api/asignatura/1"))
                .andExpect(status().isConflict());
    }
}
