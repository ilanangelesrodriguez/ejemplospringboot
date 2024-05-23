package com.sistemas.EjemploSpringBoot.dominio.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 35, nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 35, message = "El nombre debe tener entre 2 y 35 caracteres")
    private String nombre;

    @Column(length = 35, nullable = false)
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 35, message = "El apellido debe tener entre 2 y 35 caracteres")
    private String apellido;

    @Column(length = 8, nullable = false, unique = true)
    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    private String dni;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    private Date fechaNacimiento;

    @Column(length = 9, nullable = false, unique = true)
    @NotBlank(message = "El celular no puede estar vacío")
    @Size(min = 9, max = 9, message = "El celular debe tener 9 caracteres")
    private String celular;

    @Column(length = 80, nullable = false, unique = true)
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Column(length = 100, nullable = false)
    private String direccion;

    private Double promedio;

    @OneToMany(
            mappedBy = "alumno",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Nota> notas;

}
