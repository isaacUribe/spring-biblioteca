package com.example.biblioteca.service;

import com.example.biblioteca.entities.Pais;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.PaisRepository;
import com.example.biblioteca.validaciones.Validacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

//    public List<Pais> findAll(){
//        return paisRepository.findAll();
//    }


    public Pais create (Pais pais) throws Exception{
        String nombre = pais.getNombre();
        boolean exist = paisRepository.existsByNombre(nombre);
        Validacion.validarCampoYaEstaPresente(exist,nombre);
        return paisRepository.save(pais);

    }


}
