package com.sistemas.EjemploSpringBoot.dominio.servicios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Curso;
import com.sistemas.EjemploSpringBoot.dominio.repositorios.RepositorioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCursoImpl implements ServicioCurso {

    @Autowired
    private RepositorioCurso repositorioCurso;

    @Override
    public Curso buscarPorId(Long aLong) {
        Curso encontrado = null;
        if (repositorioCurso.findById(aLong).isPresent()) {
            encontrado = repositorioCurso.findById(aLong).get();
        } else {
            System.out.println("No se ha encontrado el curso con el id: " + aLong);
        }
        return encontrado;
    }

    @Override
    public Curso guardar(Curso curso) {
        return repositorioCurso.save(curso);
    }

    @Override
    public Iterable<Curso> buscarTodos() {
        return null;
    }

    @Override
    public List<Curso> listarTodos() {
        return (List<Curso>) repositorioCurso.findAll();
    }

    @Override
    public Curso actualizar(Curso curso) {
        return repositorioCurso.save(curso);
    }

    @Override
    public void eliminarPorId(Long aLong) {
        repositorioCurso.deleteById(aLong);
    }
}
