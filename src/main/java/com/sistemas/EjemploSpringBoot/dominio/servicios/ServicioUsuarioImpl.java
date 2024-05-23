package com.sistemas.EjemploSpringBoot.dominio.servicios;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Usuario;
import com.sistemas.EjemploSpringBoot.dominio.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public Usuario buscarPorId(Long aLong) {
        Usuario encontrado = null;
        if (repositorioUsuario.findById(aLong).isPresent()) {
            encontrado = repositorioUsuario.findById(aLong).get();
        } else {
            System.out.println("No se ha encontrado el usuario con el id: " + aLong);
        }
        return encontrado;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Iterable<Usuario> buscarTodos() {
        return repositorioUsuario.findAll();
    }

    @Override
    public List<Usuario> listarTodos() {
        return (List<Usuario>) repositorioUsuario.findAll();
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public void eliminarPorId(Long aLong) {
        repositorioUsuario.deleteById(aLong);
    }
}
