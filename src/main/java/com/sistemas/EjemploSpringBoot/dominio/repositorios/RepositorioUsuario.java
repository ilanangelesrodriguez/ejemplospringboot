package com.sistemas.EjemploSpringBoot.dominio.repositorios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
}
