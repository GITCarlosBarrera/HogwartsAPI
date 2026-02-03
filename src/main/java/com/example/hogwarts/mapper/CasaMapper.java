package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.CasaDTO;
import com.example.hogwarts.model.Casa;

public class CasaMapper {
    private ProfesorMapper profesorMapper;

    public CasaDTO toDto(Casa casa) {
        if (casa == null) return null;

        CasaDTO dto = new CasaDTO();
        dto.setIdCasa(casa.getIdCasa());
        dto.setNombreCasa(casa.getNombreCasa());
        dto.setFundador(casa.getFundadorCasa());

        if (casa.getProfesor() != null) {
            dto.setJefe(profesorMapper.toDto(casa.getProfesor()));
        } else {
            dto.setJefe(null);
        }

        if (casa.getEstudiantes() != null) {
            dto.setEstudiantes(casa.getEstudiantes().stream()
                    .map(e -> e.getNombreEstudiante() + " " + e.getApellidoEstudiante())
                    .toList());
        } else {
            dto.setEstudiantes(null);
        }

        return dto;
    }
}
