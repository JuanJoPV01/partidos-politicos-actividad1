package com.ejercicio24.partidopoliticomvcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    public void enviarCorreoRecuperacion(String destinatario, String nuevaClave) {
        if (mailSender == null) {
            System.out.println("SIMULACION EMAIL A " + destinatario + ": Clave temporal = " + nuevaClave);
            return;
        }

        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(destinatario);
            mensaje.setSubject("Recuperacion de Clave - Partidos Politicos");
            mensaje.setText("Hola,\n\nTu nueva clave temporal es: " + nuevaClave + "\n\nInicia sesion para actualizarla.");
            mailSender.send(mensaje);
        } catch (Exception e) {
            System.err.println("Error enviando correo: " + e.getMessage());
        }
    }
}
