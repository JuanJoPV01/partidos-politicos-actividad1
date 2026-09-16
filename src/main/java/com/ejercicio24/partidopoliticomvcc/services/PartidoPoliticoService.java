package com.ejercicio24.partidopoliticomvcc.services;

import com.ejercicio24.partidopoliticomvcc.models.PartidoPolitico;
import com.ejercicio24.partidopoliticomvcc.repositories.PartidoPoliticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoPoliticoService {

    @Autowired
    private PartidoPoliticoRepository partidoRepository;

    public List<PartidoPolitico> listarTodos() {
        return partidoRepository.findAll();
    }

    public Optional<PartidoPolitico> obtenerPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public PartidoPolitico guardar(PartidoPolitico partido) {
        return partidoRepository.save(partido);
    }

    public void eliminar(Long id) {
        partidoRepository.deleteById(id);
    }

    public List<PartidoPolitico> buscarPorPais(String pais) {
        return partidoRepository.findByPaisContainingIgnoreCase(pais);
    }

    public List<PartidoPolitico> buscarPorMinCongresistas(Integer minCongresistas) {
        return partidoRepository.findByNumCongresistasGreaterThanEqual(minCongresistas);
    }
}
