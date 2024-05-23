package com.sistemas.EjemploSpringBoot.dominio.servicios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Nota;
import com.sistemas.EjemploSpringBoot.dominio.repositorios.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicioImpl implements NotaServicio {

    @Autowired
    private RepositorioNota repositorioNota;

    @Override
    public Nota buscarPorId(Long aLong) {
        Nota encontrado = null;
        if (repositorioNota.findById(aLong).isPresent()) {
            encontrado = repositorioNota.findById(aLong).get();
        } else {
            System.out.println("No se ha encontrado la nota con el id: " + aLong);
        }
        return encontrado;
    }

    @Override
    public Nota guardar(Nota nota) {
        return repositorioNota.save(nota);
    }

    @Override
    public Iterable<Nota> buscarTodos(){
        return repositorioNota.findAll();
    }

    @Override
    public List<Nota> listarTodos() {
        return (List<Nota>) repositorioNota.findAll();
    }

    @Override
    public Nota actualizar(Nota nota) {
        return repositorioNota.save(nota);
    }

    @Override
    public void eliminarPorId(Long aLong) {
        repositorioNota.deleteById(aLong);
    }
}
