package com.sistemas.EjemploSpringBoot.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaID implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long alumno;
    private Long curso;

}
