package com.sistemas.EjemploSpringBoot.dominio.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cursos")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre del curso no puede estar vacío")
    private String nombre;

    @Min(value = 1, message = "Los créditos deben ser al menos 1")
    @NotNull(message = "Los créditos no pueden ser nulos")
    private Integer creditos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "docente_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "FK_docente_cursos"
            )
    )
    private Docente docente;

    @OneToMany(
            mappedBy = "curso",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Nota> notas;

    public Curso() {
        this.docente = new Docente();
    }
}
