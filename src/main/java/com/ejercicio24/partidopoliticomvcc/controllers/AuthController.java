package com.ejercicio24.partidopoliticomvcc.controllers;

import com.ejercicio24.partidopoliticomvcc.models.Usuario;
import com.ejercicio24.partidopoliticomvcc.services.EmailService;
import com.ejercicio24.partidopoliticomvcc.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/recuperar-clave")
    public String mostrarFormularioRecuperacion() {
        return "recuperar-clave";
    }

    @PostMapping("/recuperar-clave")
    public String procesarRecuperacion(@RequestParam("email") String email, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            String nuevaClave = UUID.randomUUID().toString().substring(0, 8);
            usuario.setClave(nuevaClave);
            usuarioService.guardar(usuario);

            emailService.enviarCorreoRecuperacion(email, nuevaClave);
            model.addAttribute("mensajeExito", "Se ha enviado una clave temporal a su correo electronico.");
        } else {
            model.addAttribute("mensajeError", "El correo electronico no se encuentra registrado.");
        }
        return "recuperar-clave";
    }
}