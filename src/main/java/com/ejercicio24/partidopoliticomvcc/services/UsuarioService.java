package com.ejercicio24.partidopoliticomvcc.services;

import com.ejercicio24.partidopoliticomvcc.models.Usuario;
import com.ejercicio24.partidopoliticomvcc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario guardar(Usuario usuario) {
        if (usuario.getClave() != null && !usuario.getClave().startsWith("$2a$")) {
            usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        }
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> buscarPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
