package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.CasaDTO;
import com.example.hogwarts.mapper.CasaMapper;
import com.example.hogwarts.model.Casa;
import com.example.hogwarts.repository.CasaRepository;
import com.example.hogwarts.service.CasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CasaServiceImpl implements CasaService {
    private CasaRepository casaRepository;
    private CasaMapper casaMapper;

    @Override
    public List<CasaDTO> obtenerTodasLasCasas() {
        List<Casa> lista = casaRepository.findAll();

        return lista.stream()
                .map(casaMapper::toDto)
                .toList();
    }
}
