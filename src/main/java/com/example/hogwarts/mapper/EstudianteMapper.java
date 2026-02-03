package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.model.Estudiante;

public class EstudianteMapper {
    public static EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setNombre(estudiante.getNombreEstudiante() + " " + estudiante.getApellidoEstudiante());
        dto.setAnyoCurso(estudiante.getAnyoCursoEstudiante());
        dto.setFechaNacimiento(estudiante.getFechaNacimientoEstudiante());
        dto.setCasa(estudiante.getCasa().getNombreCasa());

        if (estudiante.getMascota() != null) {
            dto.setMascota(MascotaMapper.toDTO(estudiante.getMascota()));
        } else {
            dto.setMascota(null);
        }

        if (estudiante.getCalificaciones() != null) {
            dto.setAsignaturas(estudiante.getCalificaciones().stream()
                    .map(c -> AsignaturaCalificacionMapper.toDTO(c))
                    .toList()
            );
        } else {
            dto.setAsignaturas(null);
        }

    }
}
