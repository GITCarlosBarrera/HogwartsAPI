package com.example.hogwarts.dto.update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteUpdateDTO {
    @NotNull(message = "El año del curso no puede estar vacío")
    private Long anyoCurso;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    private LocalDate fechaNacimiento;

    @Valid
    private MascotaUpdateDTO mascota;
}
