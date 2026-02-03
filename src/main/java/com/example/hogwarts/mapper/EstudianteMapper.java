package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.model.Casa;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.repository.CasaRepository;

public class EstudianteMapper {
    private MascotaMapper mascotaMapper;
    private AsignaturaCalificacionMapper asignaturaCalificacionMapper;

    public EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setNombre(estudiante.getNombreEstudiante() + " " + estudiante.getApellidoEstudiante());
        dto.setAnyoCurso(estudiante.getAnyoCursoEstudiante());
        dto.setFechaNacimiento(estudiante.getFechaNacimientoEstudiante());
        dto.setCasa(estudiante.getCasa().getNombreCasa());

        if (estudiante.getMascota() != null) {
            dto.setMascota(mascotaMapper.toDTO(estudiante.getMascota()));
        } else {
            dto.setMascota(null);
        }

        if (estudiante.getCalificaciones() != null) {
            dto.setAsignaturas(estudiante.getCalificaciones().stream()
                    .map(c -> asignaturaCalificacionMapper.toDTO(c))
                    .toList()
            );
        } else {
            dto.setAsignaturas(null);
        }

        return dto;
    }

    public Estudiante toEntity(EstudianteCreateDTO dto, CasaRepository casaRepository) {
        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        estudiante.setNombreEstudiante(dto.getNombre().split(" ")[0]);
        estudiante.setApellidoEstudiante(dto.getNombre().split(" ", 2)[0]);
        estudiante.setAnyoCursoEstudiante(dto.getAnyoCurso());
        estudiante.setFechaNacimientoEstudiante(dto.getFechaNacimiento());

        Casa casa = casaRepository.findById(dto.getIdCasa())
                .orElseThrow(() -> new RuntimeException("No se encontro una casa con el id: " + dto.getIdCasa()));
        estudiante.setCasa(casa);

        estudiante.setMascota(mascotaMapper.toEntity(dto.getMascota()));

        return estudiante;
    }
}
