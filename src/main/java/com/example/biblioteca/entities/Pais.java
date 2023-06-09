package com.example.biblioteca.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Integer idPais;
    private String nombre;

    @OneToMany(mappedBy = "pais")
    private List<Author> author;

    public Pais() {
    }

    public Pais(Integer idPais, String nombre) {
        this.idPais = idPais;
        this.nombre = nombre;
    }

    public Integer getId() {
        return idPais;
    }

    public void setId(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}


