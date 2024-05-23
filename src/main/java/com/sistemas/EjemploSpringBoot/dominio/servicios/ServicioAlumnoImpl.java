package com.sistemas.EjemploSpringBoot.dominio.servicios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Alumno;
import com.sistemas.EjemploSpringBoot.dominio.repositorios.RepositorioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAlumnoImpl implements ServicioAlumno {

    @Autowired
    private RepositorioAlumno repositorioAlumno;

    @Override
    public Alumno buscarPorId(Long aLong) {
        Alumno encontrado = null;
        if (repositorioAlumno.findById(aLong).isPresent()) {
            encontrado = repositorioAlumno.findById(aLong).get();
        } else {
            System.out.println("No se ha encontrado el alumno con el id: " + aLong);
        }
        return encontrado;
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return repositorioAlumno.save(alumno);
    }

    @Override
    public Iterable<Alumno> buscarTodos() {
        return null;
    }

    @Override
    public List<Alumno> listarTodos() {
        return (List<Alumno>) repositorioAlumno.findAll();
    }

    @Override
    public Alumno actualizar(Alumno alumno) {
        return repositorioAlumno.save(alumno);
    }

    @Override
    public void eliminarPorId(Long aLong) {
        repositorioAlumno.deleteById(aLong);
    }
}
