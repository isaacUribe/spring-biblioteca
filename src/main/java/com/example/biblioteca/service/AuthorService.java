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
            return authorRepository.findAll();
    }

    @Override
    public Author findById(Integer id) throws Exception {
            Optional<Author> author = authorRepository.findById(id);
            return author.get();

    }

    @Override
    public Author create(Author author) throws Exception {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Integer id, Author author) throws Exception {
        return authorRepository.save(author);
    }

    @Override
    public boolean daleteById(Integer id) throws Exception {
        authorRepository.deleteById(id);
        return true;
    }
}
