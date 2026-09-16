package com.ejercicio24.partidopoliticomvcc.repositories;

import com.ejercicio24.partidopoliticomvcc.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByEmail(String email);

    // Consulta Parametrizada 1: Filtrar usuarios por rol
    List<Usuario> findByRol(String rol);

    // Consulta Parametrizada 2: Buscar usuarios por coincidencia en el nombre
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
