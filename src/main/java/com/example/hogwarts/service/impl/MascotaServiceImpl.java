package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.mapper.MascotaMapper;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.MascotaRepository;
import com.example.hogwarts.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    private MascotaRepository mascotaRepository;

    @Override
    public List<MascotaDTO> obtenerTodasLasMascotas() {
        List<Mascota> lista = mascotaRepository.findAll();

        return lista.stream()
                .map(MascotaMapper::toDTO)
                .toList();
    }
}
