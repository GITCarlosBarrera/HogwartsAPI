package com.example.hogwarts.service.impl;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.update.EstudianteUpdateDTO;
import com.example.hogwarts.mapper.EstudianteMapper;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.repository.CasaRepository;
import com.example.hogwarts.repository.EstudianteRepository;
import com.example.hogwarts.repository.MascotaRepository;
import com.example.hogwarts.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.jdbc.XmlAsStringArrayJdbcTypeConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private CasaRepository casaRepository;
    private EstudianteRepository estudianteRepository;
    private MascotaRepository mascotaRepository;
    private EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> lista = estudianteRepository.findAll();

        return lista.stream()
                .map(estudianteMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto, casaRepository);

        // Vinculacion de estudiante con mascota
        if (estudiante.getMascota() != null) {
            estudiante.getMascota().setEstudiante(estudiante);
        }

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return estudianteMapper.toDto(estudianteGuardado);
    }

    @Override
    @Transactional
    public EstudianteDTO actualizarEstudiante(Integer id, EstudianteUpdateDTO dto) {
        Estudiante estudianteExistente = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado con id:" + id));

        estudianteMapper.updateEntityFromDto(dto, estudianteExistente);
        Estudiante estudianteActualizado = estudianteRepository.save(estudianteExistente);

        return estudianteMapper.toDto(estudianteActualizado);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Integer id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El estudiante con ID " + id + " no existe"));

        if (!estudiante.getCalificaciones().isEmpty()) throw new IllegalStateException("No se puede un estudiante con calificaciones asignadas");

        if (estudiante.getMascota() != null) {
            mascotaRepository.delete(estudiante.getMascota());
            estudiante.setMascota(null);
        }

        estudianteRepository.delete(estudiante);
    }
}
