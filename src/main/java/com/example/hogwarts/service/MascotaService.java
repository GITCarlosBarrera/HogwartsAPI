package com.example.hogwarts.service;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.create.MascotaCreateDTO;

import java.util.List;

public interface MascotaService {
    public List<MascotaDTO> obtenerTodasLasMascotas();
    public MascotaDTO crearMascota(MascotaCreateDTO dto);
}
