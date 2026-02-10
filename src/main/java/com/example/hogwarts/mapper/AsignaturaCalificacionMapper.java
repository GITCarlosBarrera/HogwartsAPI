package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.AsignaturaCalificacionDTO;
import com.example.hogwarts.model.EstudianteAsignatura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AsignaturaCalificacionMapper {
    public AsignaturaCalificacionDTO toDto(EstudianteAsignatura asignaturaCalificacion) {
        if (asignaturaCalificacion == null) return null;

        AsignaturaCalificacionDTO dto = new AsignaturaCalificacionDTO();
        dto.setAsignatura(asignaturaCalificacion.getAsignatura().getNombreAsignatura());
        dto.setCalificacion(asignaturaCalificacion.getCalificacion());

        return dto;
    }
}
