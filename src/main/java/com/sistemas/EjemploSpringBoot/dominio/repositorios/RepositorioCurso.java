package com.sistemas.EjemploSpringBoot.dominio.repositorios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Curso;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCurso extends CrudRepository<Curso, Long> {
}
