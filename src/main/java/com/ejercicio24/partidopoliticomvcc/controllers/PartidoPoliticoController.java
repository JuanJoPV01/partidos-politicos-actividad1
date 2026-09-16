package com.ejercicio24.partidopoliticomvcc.controllers;

import com.ejercicio24.partidopoliticomvcc.models.PartidoPolitico;
import com.ejercicio24.partidopoliticomvcc.services.PartidoPoliticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/partidos")
public class PartidoPoliticoController {

    @Autowired
    private PartidoPoliticoService partidoService;

    @GetMapping
    public String listarPartidos(Model model) {
        model.addAttribute("partidos", partidoService.listarTodos());
        return "partidos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("partido", new PartidoPolitico());
        return "partidos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPartido(@ModelAttribute("partido") PartidoPolitico partido) {
        partidoService.guardar(partido);
        return "redirect:/partidos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        partidoService.obtenerPorId(id).ifPresent(p -> model.addAttribute("partido", p));
        return "partidos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPartido(@PathVariable("id") Long id) {
        partidoService.eliminar(id);
        return "redirect:/partidos";
    }

    @GetMapping("/reportes")
    public String reportes(
            @RequestParam(value = "pais", required = false) String pais,
            @RequestParam(value = "minCongresistas", required = false) Integer minCongresistas,
            Model model) {

        if (pais != null && !pais.isEmpty()) {
            model.addAttribute("partidosPorPais", partidoService.buscarPorPais(pais));
            model.addAttribute("paramPais", pais);
        }

        if (minCongresistas != null) {
            model.addAttribute("partidosPorCongresistas", partidoService.buscarPorMinCongresistas(minCongresistas));
            model.addAttribute("paramMinCongresistas", minCongresistas);
        }

        return "partidos/reportes";
    }
}