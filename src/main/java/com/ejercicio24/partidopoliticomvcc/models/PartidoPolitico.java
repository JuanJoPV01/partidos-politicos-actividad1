package com.ejercicio24.partidopoliticomvcc.models;

import jakarta.persistence.*;

@Entity
@Table(name = "partidos_politicos")
public class PartidoPolitico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String eslogan;
    private String presidente;
    private String secretario;
    private String tesorero;
    private String pais;

    private Integer numPresidentes;
    private Integer numGobernadores;
    private Integer numAlcaldes;
    private Integer numConcejales;
    private Integer numCongresistas;

    public PartidoPolitico() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEslogan() { return eslogan; }
    public void setEslogan(String eslogan) { this.eslogan = eslogan; }

    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }

    public String getSecretario() { return secretario; }
    public void setSecretario(String secretario) { this.secretario = secretario; }

    public String getTesorero() { return tesorero; }
    public void setTesorero(String tesorero) { this.tesorero = tesorero; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public Integer getNumPresidentes() { return numPresidentes; }
    public void setNumPresidentes(Integer numPresidentes) { this.numPresidentes = numPresidentes; }

    public Integer getNumGobernadores() { return numGobernadores; }
    public void setNumGobernadores(Integer numGobernadores) { this.numGobernadores = numGobernadores; }

    public Integer getNumAlcaldes() { return numAlcaldes; }
    public void setNumAlcaldes(Integer numAlcaldes) { this.numAlcaldes = numAlcaldes; }

    public Integer getNumConcejales() { return numConcejales; }
    public void setNumConcejales(Integer numConcejales) { this.numConcejales = numConcejales; }

    public Integer getNumCongresistas() { return numCongresistas; }
    public void setNumCongresistas(Integer numCongresistas) { this.numCongresistas = numCongresistas; }
}
