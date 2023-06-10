package com.example.biblioteca.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.biblioteca.entities.Author;
import com.example.biblioteca.excepcion.EmailIncorrecto;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.excepcion.NoEncontrado;
import com.example.biblioteca.repository.AuthorRepository;
import com.example.biblioteca.validaciones.Validacion;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

            Validacion.validarSiEstaPorElId(author);
            return author.get();
    }
    @Override
    public Author create(Author author) throws Exception {
        String email = author.getEmail();
        String nombre = author.getNombre();
        String pseudonimo = author.getPseudonimo();

        Validacion.validarEmail(email);
        if (nombre == null || nombre.isEmpty()){
            if (pseudonimo == null || pseudonimo.isEmpty()){
                throw new IsPresentOrNull("Tienes que elegir entre nombre o pseudonimo pero no puedes dejar los dos campos vacios");
            }
        }

        return authorRepository.save(author);
    }

    @Override
    public Author update(Integer id, Author author) throws Exception {
        Optional<Author> evaluar = authorRepository.findById(id);
        Validacion.validarSiEstaPorElId(evaluar);

            Author authorExistente = evaluar.get();
            authorExistente.setIdPais(author.getIdPais());
            authorExistente.setNombre(author.getNombre());
            authorExistente.setPseudonimo(author.getPseudonimo());
            authorExistente.setEmail(author.getEmail());
            return authorRepository.save(authorExistente);
    }

    @Override
    public boolean daleteById(Integer id) throws Exception {
        Optional<Author> author = authorRepository.findById(id);
        Validacion.validarSiEstaPorElId(author);
            authorRepository.deleteById(id);
            return true;

    }


}
