package com.sistemas.EjemploSpringBoot.infraestructura.controladores;

import com.sistemas.EjemploSpringBoot.dominio.entidades.Docente;
import com.sistemas.EjemploSpringBoot.dominio.servicios.ServicioDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteControlador {

    @Autowired
    private ServicioDocente servicioDocente;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("docentes", servicioDocente.listarTodos());
        return "docentes/listar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("docente", new Docente());
        return "docentes/crear";
    }

    @PostMapping("/guardar")
    public String guardar(Docente docente) {
        servicioDocente.guardar(docente);
        return "redirect:/docentes/listar";
    }
}