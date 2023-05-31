package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Ubicacion;
import com.example.biblioteca.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ubicacion")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @PostMapping("/create")
    public Ubicacion create (@RequestBody Ubicacion ubicacion){
        return ubicacionService.create(ubicacion);
    }

}
