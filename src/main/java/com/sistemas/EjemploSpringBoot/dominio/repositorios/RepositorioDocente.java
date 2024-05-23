package com.sistemas.EjemploSpringBoot.dominio.repositorios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Docente;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioDocente extends CrudRepository<Docente, Long>{
}
