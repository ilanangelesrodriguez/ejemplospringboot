package com.sistemas.EjemploSpringBoot.dominio.repositorios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Nota;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioNota extends CrudRepository<Nota, Long>{
}
