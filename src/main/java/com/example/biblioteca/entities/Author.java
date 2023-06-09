package com.example.biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.context.annotation.Conditional;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_pais")
    private Integer idPais;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column (name = "pseudonimo")
    private String pseudonimo;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pais", insertable = false, updatable = false)
    private Pais pais;

    public Author() {
    }

    public Author(Integer id, Integer idPais, String nombre, String pseudonimo, String email, Pais pais) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
        this.pseudonimo = pseudonimo;
        this.email = email;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
