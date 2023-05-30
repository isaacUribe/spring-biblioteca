package com.example.biblioteca.service;

import com.example.biblioteca.entities.Categoria;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.CategoriaRepository;
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
        if (categoriaRepository.existsByNombre(categoria.getNombre()) || categoria.getNombre().length()<1){
            throw new IsPresentOrNull("La categoria ya se encuentra o es null");
        }
        return categoriaRepository.save(categoria);
    }

}
