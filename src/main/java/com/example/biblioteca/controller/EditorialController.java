package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.repository.EditorialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EditorialController {
    private EditorialRepository editorialRepository;

    public EditorialController(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @GetMapping("/api/editoriales")
    public List<Editorial> findAll(){
        return editorialRepository.findAll();
    }

    @PostMapping("api/editoriales")
    public Editorial crear (@RequestBody Editorial editorial){
        return  editorialRepository.save(editorial);
    }

    @DeleteMapping("api/editoriales")
    public ResponseEntity<Editorial> deleteAll(){
        editorialRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
