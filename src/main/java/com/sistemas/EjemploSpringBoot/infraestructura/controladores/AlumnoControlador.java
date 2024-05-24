package com.sistemas.EjemploSpringBoot.infraestructura.controladores;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Alumno;
import com.sistemas.EjemploSpringBoot.dominio.servicios.ServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoControlador {

    @Autowired
    private ServicioAlumno servicioAlumno;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alumnos", servicioAlumno.listarTodos());
        return "alumnos/listar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumnos/crear";
    }

    @PostMapping("/guardar")
    public String guardar(Alumno alumno) {
        servicioAlumno.guardar(alumno);
        return "redirect:/alumnos/listar";
    }
}