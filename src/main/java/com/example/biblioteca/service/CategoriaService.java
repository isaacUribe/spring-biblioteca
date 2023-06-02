package com.example.biblioteca.service;

import com.example.biblioteca.entities.Categoria;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.CategoriaRepository;
import com.example.biblioteca.validaciones.Validacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public Categoria create (Categoria categoria) throws Exception{
        String nombre = categoria.getNombre();
        boolean exist = categoriaRepository.existsByNombre(categoria.getNombre());
        Validacion.validarCampoYaEstaPresente(exist,nombre);
        return categoriaRepository.save(categoria);
    }

}
