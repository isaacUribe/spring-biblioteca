package com.example.biblioteca.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.biblioteca.entities.Author;
import com.example.biblioteca.excepcion.NoEncontrado;
import com.example.biblioteca.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements BaseService<Author> {

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> findAll() throws Exception {
        try {
            List<Author> authors = authorRepository.findAll();
            return authors;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Author findById(Integer id) throws Exception {
        try {
            Optional<Author> author = authorRepository.findById(id);
            return author.get();
        }catch (Exception e){
            throw new NoEncontrado("El author no ha sido encontrado");
        }

    }

    @Override
    public Author create(Author datosRegistrar) throws Exception {
        return null;
    }

    @Override
    public Author update(Integer id, Author datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean daleteById(Integer id) throws Exception {
        return false;
    }
}
