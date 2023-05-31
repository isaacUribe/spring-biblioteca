package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Pais;
import com.example.biblioteca.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @PostMapping("/create")
     public Pais create(@RequestBody Pais pais) throws Exception {
         return paisService.create(pais);
     }
}
