package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.repository.EditorialRepository;
import com.example.biblioteca.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EditorialController {

    @Autowired
    private EditorialService editorialService;


    @GetMapping("/api/editoriales")
    public List<Editorial> findAll() throws Exception {
        return editorialService.findAll();
    }

    @PostMapping("api/editoriales")
    public Editorial registrar(@RequestBody Editorial datosRegistrar) throws Exception {

        return  editorialService.registrar(datosRegistrar);
    }

    @PostMapping("api/editorialer/{id}")
    public Editorial actualizar(@PathVariable Integer id, @RequestBody Editorial datosNuevos) throws Exception{
        return editorialService.actualizar(id,datosNuevos);
    }


}
