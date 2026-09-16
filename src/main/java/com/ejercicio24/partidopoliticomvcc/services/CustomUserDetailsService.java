package com.ejercicio24.partidopoliticomvcc.services;

import com.ejercicio24.partidopoliticomvcc.models.Usuario;
import com.ejercicio24.partidopoliticomvcc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new User(
                usuario.getNombre(),
                usuario.getClave(),
                Collections.singletonList(new SimpleGrantedAuthority(usuario.getRol()))
        );
    }
}
