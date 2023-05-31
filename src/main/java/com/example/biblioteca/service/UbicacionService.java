package com.example.biblioteca.service;

import com.example.biblioteca.entities.Ubicacion;
import com.example.biblioteca.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Ubicacion create (Ubicacion ubicacion){
        return ubicacionRepository.save(ubicacion);
    }
}
