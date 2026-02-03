package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.model.Asignatura;

public class AsignaturaMapper {

    public static AsignaturaDTO toDTO(Asignatura asignatura) {
        if (asignatura == null) {
            return null;
        }

        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setIdAsignatura(asignatura.getIdAsignatura());
        dto.setNombreAsignatura(asignatura.getNombreAsignatura());
        dto.setAula(asignatura.getAula());
        dto.setAsignaturaObligatoria(asignatura.isAsignaturaObligatoria());

        if (asignatura.getProfesor() != null) {
            String nombreCompleto = asignatura.getProfesor().getNombreProfesor() + " " +
                    asignatura.getProfesor().getApellidoProfesor();
            dto.setProfesor(nombreCompleto);
        } else {
            dto.setProfesor("Sin profesor asignado");
        }

        return dto;
    }
}