package com.sistemas.EjemploSpringBoot.dominio.servicios;

import java.util.List;

public interface iServicioGenerico <Entidad, Id> {
    Entidad buscarPorId(Id id);
    Entidad guardar(Entidad entidad);
    Iterable<Entidad> buscarTodos();
    List<Entidad> listarTodos();
    Entidad actualizar(Entidad entidad);
    void eliminarPorId(Id id);
}
