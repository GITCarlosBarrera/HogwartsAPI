package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.create.EstudianteCreateDTO;
import com.example.hogwarts.dto.update.EstudianteUpdateDTO;
import com.example.hogwarts.model.Casa;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.CasaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstudianteMapper {
    private final MascotaMapper mascotaMapper;
    private final AsignaturaCalificacionMapper asignaturaCalificacionMapper;

    public EstudianteDTO toDto(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getIdEstudiante());
        dto.setNombre(estudiante.getNombreEstudiante() + " " + estudiante.getApellidoEstudiante());
        dto.setAnyoCurso(estudiante.getAnyoCursoEstudiante());
        dto.setFechaNacimiento(estudiante.getFechaNacimientoEstudiante());
        dto.setCasa(estudiante.getCasa().getNombreCasa());

        if (estudiante.getMascota() != null) {
            dto.setMascota(mascotaMapper.toDto(estudiante.getMascota()));
        } else {
            dto.setMascota(null);
        }

        if (estudiante.getCalificaciones() != null) {
            dto.setAsignaturas(estudiante.getCalificaciones().stream()
                    .map(c -> asignaturaCalificacionMapper.toDto(c))
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
        estudiante.setNombreEstudiante(dto.getNombre());
        estudiante.setApellidoEstudiante(dto.getApellido());
        estudiante.setAnyoCursoEstudiante(dto.getAnyoCurso());
        estudiante.setFechaNacimientoEstudiante(dto.getFechaNacimiento());

        Casa casa = casaRepository.findById(dto.getIdCasa())
                .orElseThrow(() -> new RuntimeException("No se encontro una casa con el id: " + dto.getIdCasa()));
        estudiante.setCasa(casa);

        if (dto.getMascota() != null) {
            Mascota mascota = mascotaMapper.toEntity(dto.getMascota());
            estudiante.setMascota(mascota);
            mascota.setEstudiante(estudiante);
        }

        return estudiante;
    }

    public void updateEntityFromDto(EstudianteUpdateDTO dto, Estudiante estudiante) {
        if (dto == null || estudiante == null) return;

        estudiante.setAnyoCursoEstudiante(dto.getAnyoCurso());
        estudiante.setFechaNacimientoEstudiante(dto.getFechaNacimiento());
        if (dto.getMascotaUpdateDTO() != null) {
            Mascota nueva = mascotaMapper.toEntity(dto.getMascotaUpdateDTO());
            nueva.setEstudiante(estudiante);
            estudiante.setMascota(nueva);
        } else {
            estudiante.setMascota(null);
        }
    }
}
