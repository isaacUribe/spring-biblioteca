package com.example.biblioteca.repository;

import com.example.biblioteca.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    boolean existsByNombre (String nombre);
}
