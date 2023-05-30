package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Categoria;
import com.example.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/findAll")
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }
    @PostMapping("/create")
    public Categoria create(@RequestBody Categoria categoria) throws Exception {
        return categoriaService.create(categoria);
    }
}
