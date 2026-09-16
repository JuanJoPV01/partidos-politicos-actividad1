package com.ejercicio24.partidopoliticomvcc.controllers;

import com.ejercicio24.partidopoliticomvcc.models.Usuario;
import com.ejercicio24.partidopoliticomvcc.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        usuarioService.obtenerPorId(id).ifPresent(u -> model.addAttribute("usuario", u));
        return "usuarios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/reportes")
    public String reportes(
            @RequestParam(value = "rol", required = false) String rol,
            @RequestParam(value = "nombre", required = false) String nombre,
            Model model) {

        if (rol != null && !rol.isEmpty()) {
            model.addAttribute("usuariosPorRol", usuarioService.buscarPorRol(rol));
            model.addAttribute("paramRol", rol);
        }

        if (nombre != null && !nombre.isEmpty()) {
            model.addAttribute("usuariosPorNombre", usuarioService.buscarPorNombre(nombre));
            model.addAttribute("paramNombre", nombre);
        }

        return "usuarios/reportes";
    }
}