package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.AsignaturaCalificacionDTO;
import com.example.hogwarts.model.EstudianteAsignatura;

public class AsignaturaCalificacionMapper {
    public AsignaturaCalificacionDTO toDTO(EstudianteAsignatura asignaturaCalificacion) {
        if (asignaturaCalificacion == null) return null;

        AsignaturaCalificacionDTO dto = new AsignaturaCalificacionDTO();
        dto.setAsignatura(asignaturaCalificacion.getAsignatura().getNombreAsignatura());
        dto.setCalificacion(asignaturaCalificacion.getCalificacion());

        return dto;
    }
}
