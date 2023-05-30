package com.example.biblioteca.service;

import com.example.biblioteca.entities.Pais;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll(){
        return paisRepository.findAll();
    }

    public Pais create (Pais pais) throws Exception{
        if(paisRepository.existsByNombre(pais.getNombre()) || pais.getNombre() == null){
            throw new IsPresentOrNull("Es pais ya existe o el campo nombre esta vacio");
        }
        System.out.println("paso por aqui");
        return paisRepository.save(pais);

    }


}
