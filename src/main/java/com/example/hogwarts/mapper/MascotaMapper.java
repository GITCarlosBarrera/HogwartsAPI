package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.model.Mascota;

public class MascotaMapper {
    public static MascotaDTO toDTO(Mascota mascota) {
        if (mascota == null) return null;

        MascotaDTO dto = new MascotaDTO();
        dto.setNombre(mascota.getNombreMascota());
        dto.setEspecie(mascota.getEspecieMascota());
        dto.setEstudiante(mascota.getEstudiante().getNombreEstudiante() + " " + mascota.getEstudiante().getApellidoEstudiante());

        return dto;
    }
}
