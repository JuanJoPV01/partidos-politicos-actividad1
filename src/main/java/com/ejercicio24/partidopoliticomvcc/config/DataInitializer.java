package com.ejercicio24.partidopoliticomvcc.config;

import com.ejercicio24.partidopoliticomvcc.models.PartidoPolitico;
import com.ejercicio24.partidopoliticomvcc.models.Usuario;
import com.ejercicio24.partidopoliticomvcc.repositories.PartidoPoliticoRepository;
import com.ejercicio24.partidopoliticomvcc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PartidoPoliticoRepository partidoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario();
            admin.setNombre("admin");
            admin.setClave(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@cartagena.edu.co");
            admin.setRol("ROLE_ADMIN");
            usuarioRepository.save(admin);

            Usuario user = new Usuario();
            user.setNombre("juan");
            user.setClave(passwordEncoder.encode("juan123"));
            user.setEmail("juan@cartagena.edu.co");
            user.setRol("ROLE_USER");
            usuarioRepository.save(user);
        }

        if (partidoRepository.count() == 0) {
            PartidoPolitico p1 = new PartidoPolitico();
            p1.setNombre("Partido Libres y Unidos");
            p1.setEslogan("Por un futuro con oportunidades");
            p1.setPresidente("Carlos Mendoza");
            p1.setSecretario("Ana Gomez");
            p1.setTesorero("Luis Torres");
            p1.setPais("Colombia");
            p1.setNumPresidentes(2);
            p1.setNumGobernadores(5);
            p1.setNumAlcaldes(18);
            p1.setNumConcejales(120);
            p1.setNumCongresistas(15);
            partidoRepository.save(p1);
        }
    }
}