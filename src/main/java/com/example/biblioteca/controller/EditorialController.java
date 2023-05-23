package com.example.biblioteca.controller;

import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.repository.EditorialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/editoriales/{id}")
    public ResponseEntity<Editorial> findById(@PathVariable Integer id){
        Optional<Editorial> editorial = editorialRepository.findById(id);
        return ResponseEntity.ok(editorial.get());
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

    @DeleteMapping("/api/editoriales/{id}")
    public ResponseEntity<Editorial> deleteById(@PathVariable Integer id){
        editorialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
