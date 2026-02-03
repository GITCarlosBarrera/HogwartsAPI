package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.model.Profesor;

public class ProfesorMapper {
    public ProfesorDTO toDTO(Profesor profesor) {
        if (profesor == null) return null;

        ProfesorDTO dto = new ProfesorDTO();
        dto.setIdProfesor(profesor.getIdProfesor());
        dto.setNombreProfesor(profesor.getNombreProfesor() + " " + profesor.getApellidoProfesor());

        if (profesor.getAsignatura() != null) {
            dto.setNombreAsignatura(profesor.getAsignatura().getNombreAsignatura());
        } else {
            dto.setNombreAsignatura("Sin asignatura asignada");
        }

        dto.setFechaInicio(profesor.getFechaInicioProfesor());
    }
}
