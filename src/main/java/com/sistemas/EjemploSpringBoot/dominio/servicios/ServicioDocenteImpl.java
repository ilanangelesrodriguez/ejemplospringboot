package com.sistemas.EjemploSpringBoot.dominio.servicios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Docente;
import com.sistemas.EjemploSpringBoot.dominio.repositorios.RepositorioDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDocenteImpl implements ServicioDocente {

    @Autowired
    private RepositorioDocente repositorioDocente;

    @Override
    public Docente buscarPorId(Long aLong) {

        Docente encontrado = null;
        if (repositorioDocente.findById(aLong).isPresent()) {
            encontrado = repositorioDocente.findById(aLong).get();
        } else {
            System.out.println("No se ha encontrado el docente con el id: " + aLong);
        }
        return encontrado;

    }

    @Override
    public Docente guardar(Docente docente) {
        return repositorioDocente.save(docente);
    }

    @Override
    public Iterable<Docente> buscarTodos() {
        return repositorioDocente.findAll();
    }

    @Override
    public List<Docente> listarTodos() {
        return (List<Docente>) repositorioDocente.findAll();
    }

    @Override
    public Docente actualizar(Docente docente) {
        return repositorioDocente.save(docente);
    }

    @Override
    public void eliminarPorId(Long aLong) {
        repositorioDocente.deleteById(aLong);
    }
}
