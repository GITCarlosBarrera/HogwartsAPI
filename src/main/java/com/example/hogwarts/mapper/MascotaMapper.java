package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.dto.create.MascotaCreateDTO;
import com.example.hogwarts.dto.update.MascotaUpdateDTO;
import com.example.hogwarts.model.Mascota;

public class MascotaMapper {
    public MascotaDTO toDto(Mascota mascota) {
        if (mascota == null) return null;

        MascotaDTO dto = new MascotaDTO();
        dto.setNombre(mascota.getNombreMascota());
        dto.setEspecie(mascota.getEspecieMascota());
        dto.setEstudiante(mascota.getEstudiante().getNombreEstudiante() + " " + mascota.getEstudiante().getApellidoEstudiante());

        return dto;
    }

    public Mascota toEntity(MascotaCreateDTO dto) {
        if (dto == null) return null;

        Mascota mascota = new Mascota();
        mascota.setNombreMascota(dto.getNombre());
        mascota.setEspecieMascota(dto.getEspecie());

        return mascota;
    }

    public Mascota toEntity(MascotaUpdateDTO dto) {
        if (dto == null) return null;

        Mascota mascota = new Mascota();
        mascota.setNombreMascota(dto.getNombre());
        mascota.setEspecieMascota(dto.getEspecie());

        return mascota;
    }
}
