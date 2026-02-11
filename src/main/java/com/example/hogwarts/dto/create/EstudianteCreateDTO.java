package com.example.hogwarts.dto.create;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {
    @NotBlank(message = "El nombre del estudiante no puede estar vacío")
    @Size(max = 50, message = "El nombre del estudiante no puede superar los 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido del estudiante no puede estar vacío")
    @Size(max = 50, message = "El apellido del estudiante no puede superar los 50 caracteres")
    private String apellido;

    @NotNull(message = "El año del curso no puede estar vacío")
    @Min(1)
    @Max(7)
    private long anyoCurso;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    private LocalDate fechaNacimiento;

    private Long idCasa;

    @Valid
    @NotNull(message = "La mascota es obligatoria.")
    private MascotaCreateDTO mascota;
}
