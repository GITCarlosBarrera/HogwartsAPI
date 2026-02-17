package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.create.MascotaCreateDTO;
import com.example.hogwarts.mapper.MascotaMapper;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.MascotaRepository;
import com.example.hogwarts.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;
    private final MascotaMapper mascotaMapper;

    @Override
    public List<MascotaDTO> obtenerTodasLasMascotas() {
        List<Mascota> lista = mascotaRepository.findAll();

        return lista.stream()
                .map(mascotaMapper::toDto)
                .toList();
    }

    @Override
    public MascotaDTO crearMascota(MascotaCreateDTO dto) {
        Mascota mascota = mascotaMapper.toEntity(dto);

        Mascota mascotaGuardado = mascotaRepository.save(mascota);
        return mascotaMapper.toDto(mascotaGuardado);
    }
}
