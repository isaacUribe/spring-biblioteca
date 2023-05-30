package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.repository.EditorialRepository;
import com.example.biblioteca.service.EditorialService;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/editorial")
@RestController
public class EditorialController {

    @Autowired
    private EditorialService editorialService;


    @GetMapping("/findAll")
    public List<Editorial> findAll() throws Exception {
        return editorialService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Editorial findById(@PathVariable Integer id) throws Exception {
        return editorialService.findById(id);
    }

    @PostMapping("/create")
    public Editorial registrar(@RequestBody Editorial datosRegistrar) throws Exception {

        return  editorialService.create(datosRegistrar);
    }

    @PutMapping("/update/{id}")
    public Editorial actualizar(@PathVariable Integer id, @RequestBody Editorial datosNuevos) throws Exception{
        return editorialService.update(id,datosNuevos);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Integer id) throws Exception {
        return editorialService.daleteById(id);
    }


}
