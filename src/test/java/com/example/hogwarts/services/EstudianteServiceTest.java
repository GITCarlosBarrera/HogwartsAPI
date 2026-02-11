package com.example.hogwarts.services;

import com.example.hogwarts.model.Casa;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.model.EstudianteAsignatura;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.EstudianteRepository;
import com.example.hogwarts.repository.MascotaRepository;
import com.example.hogwarts.service.impl.EstudianteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;
    @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    private Estudiante estudianteTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new Estudiante();
        estudianteTest.setIdEstudiante(1L);
        estudianteTest.setNombreEstudiante("Harry");
        estudianteTest.setApellidoEstudiante("Potter");
        estudianteTest.setCasa(new Casa());
        estudianteTest.setAnyoCursoEstudiante(1L);
        estudianteTest.setFechaNacimientoEstudiante(LocalDate.of(2003, 04, 12));
        estudianteTest.setCalificaciones(new ArrayList<>());
        estudianteTest.setMascota(new Mascota());
    }

    @Test
    void eliminarEstudiante_Exito() {
        Long id = 1L;
        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        estudianteService.eliminarEstudiante(id);

        verify(estudianteRepository, times(1)).delete(estudianteTest);
    }
}
