package com.example.biblioteca.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.biblioteca.entities.Author;
import com.example.biblioteca.excepcion.EmailIncorrecto;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.excepcion.NoEncontrado;
import com.example.biblioteca.repository.AuthorRepository;
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
            if(author.isPresent()){
                return author.get();
            }else{
                throw new NoEncontrado("Author no encontrado");
            }

    }

    @Override
    public Author create(Author author) throws Exception {
        String email = author.getEmail();
        String emailValidator = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String nombre = author.getNombre();
        String pseudonimo = author.getPseudonimo();

        if(!email.matches(emailValidator)){
            throw new EmailIncorrecto("El email es incorrecto");
        } else if (authorRepository.existsByNombre(author.getNombre())) {
            throw new IsPresentOrNull("El author ya existe");
        }
        if (nombre == null || nombre.isEmpty()){
            if (pseudonimo == null || pseudonimo.isEmpty()){
                throw new IsPresentOrNull("error");
            }
        }

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
