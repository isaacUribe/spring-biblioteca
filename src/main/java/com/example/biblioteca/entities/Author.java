package com.example.biblioteca.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authores")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column (name = "pseudonimo")
    private String pseudonimo;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "email")
    private String email;

    public Author() {
    }

    public Author(Integer id, String nombre, String pseudonimo, String nacionalidad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.pseudonimo = pseudonimo;
        this.nacionalidad = nacionalidad;
        this.email = email;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
