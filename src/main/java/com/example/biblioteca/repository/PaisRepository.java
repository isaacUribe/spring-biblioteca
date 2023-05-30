package com.example.biblioteca.repository;

import com.example.biblioteca.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

    boolean existsByNombre(String nombre);
}
