package com.sistemas.EjemploSpringBoot.dominio.repositorios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioAlumno extends CrudRepository<Alumno, Long> {
}
