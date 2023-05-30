package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Author;
import com.example.biblioteca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/findAll")
    public List<Author> findAll() throws Exception {
        return authorService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Author findById(@PathVariable Integer id) throws Exception {
        return authorService.findById(id);
    }

    @PostMapping("/create")
    public Author create (@RequestBody Author author) throws Exception {
        return authorService.create(author);

    }
}
