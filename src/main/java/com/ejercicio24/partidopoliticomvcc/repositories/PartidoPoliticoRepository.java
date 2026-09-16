package com.ejercicio24.partidopoliticomvcc.repositories;

import com.ejercicio24.partidopoliticomvcc.models.PartidoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Long> {
    List<PartidoPolitico> findByPaisContainingIgnoreCase(String pais);
    List<PartidoPolitico> findByNumCongresistasGreaterThanEqual(Integer minCongresistas);
}
