package com.example.hogwarts.repositories;

import com.example.hogwarts.model.Casa;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.EstudianteRepository;
import com.example.hogwarts.repository.MascotaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class EstudianteRepositoryIntegrationTest {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudiante_DebeEliminarMascotaEnCascada() {

        Estudiante estudiante = new Estudiante();
        estudiante = new Estudiante();
        estudiante.setNombreEstudiante("Harry");
        estudiante.setApellidoEstudiante("Potter");
        estudiante.setCasa(new Casa());
        estudiante.setAnyoCursoEstudiante(1L);
        estudiante.setFechaNacimientoEstudiante(LocalDate.of(2003, 04, 12));
        estudiante.setCalificaciones(new ArrayList<>());

        Mascota mascota = new Mascota();
        mascota.setNombreMascota("Mascota");
        mascota.setEspecieMascota("Especie");
        estudiante.setMascota(mascota);

        Estudiante guardado = estudianteRepository.save(estudiante);
        Long idMascota = guardado.getMascota().getIdMascota();

        estudianteRepository.delete(guardado);

        estudianteRepository.flush();
        entityManager.clear();

        assertFalse(estudianteRepository.findById(guardado.getIdEstudiante()).isPresent());

        Mascota mascotaEnBD = entityManager.find(Mascota.class, idMascota);
        assertNull(mascotaEnBD, "La mascota debería haber sido borrada por la cascada de JPA");
    }
}
