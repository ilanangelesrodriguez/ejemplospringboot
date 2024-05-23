package com.sistemas.EjemploSpringBoot.dominio.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@IdClass(NotaID.class)
@Table(name = "notas")
@Data
public class Nota {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "alumno_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "FK_alumno_notas"
            )
    )
    private Alumno alumno;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "curso_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "FK_curso_notas"
            )
    )
    private Curso curso;
    private Double unidad1;
    private Double unidad2;
    private Double unidad3;

}
