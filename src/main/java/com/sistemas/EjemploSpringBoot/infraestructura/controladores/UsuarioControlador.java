package com.sistemas.EjemploSpringBoot.infraestructura.controladores;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Usuario;
import com.sistemas.EjemploSpringBoot.dominio.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", servicioUsuario.listarTodos());
        return "usuarios/listar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/crear";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        servicioUsuario.guardar(usuario);
        return "redirect:/usuarios/listar";
    }
}