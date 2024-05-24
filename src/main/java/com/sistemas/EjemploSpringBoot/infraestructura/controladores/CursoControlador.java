package com.sistemas.EjemploSpringBoot.infraestructura.controladores;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Curso;
import com.sistemas.EjemploSpringBoot.dominio.servicios.ServicioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoControlador {

    @Autowired
    private ServicioCurso servicioCurso;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("cursos", servicioCurso.listarTodos());
        return "cursos/listar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/crear";
    }

    @PostMapping("/guardar")
    public String guardar(Curso curso) {
        servicioCurso.guardar(curso);
        return "redirect:/cursos/listar";
    }
}