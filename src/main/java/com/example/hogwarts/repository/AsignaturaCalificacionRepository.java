package com.example.hogwarts.repository;

import com.example.hogwarts.model.EstudianteAsignatura;
import com.example.hogwarts.model.EstudianteAsignaturaKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaCalificacionRepository extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaKey> {
}
