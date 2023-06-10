package com.example.biblioteca.service;

import com.example.biblioteca.entities.Author;
import com.example.biblioteca.entities.Pais;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.AuthorRepository;
import com.example.biblioteca.validaciones.Validacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthorServiceTest {
    private Author author;

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Integer id = 1;
        Integer idPais = 1;
        String nombre = "nombre prueba";
        String pseundonimo = "seudonimo prueba";
        String email = "mailprueba@gmail.com";
        Pais pais = new Pais();
        author = new Author(id,idPais,nombre,pseundonimo,email,pais);

    }

    @Test
    void findAll() throws Exception {
        when(authorRepository.findAll()).thenReturn(Arrays.asList(author));
        assertNotNull(authorService.findAll());

    }

    @Test
    void findById() throws Exception {
        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        Author result = authorService.findById(author.getId());
        assertEquals(result, author);
    }

    @Test
    void create_correcto_todosLosCampos() throws Exception {
        when(authorRepository.save(author)).thenReturn(author);
        Author result = authorService.create(author);
        assertEquals(result, author);
    }
    @Test
    void create_correcto_unCampoVacio() throws Exception {
        author.setNombre("");
        when(authorRepository.save(author)).thenReturn(author);
        Author result = authorService.create(author);
        assertEquals(result, author);
    }
    @Test
    void create_incorrecto_dosCamposVacios() throws  Exception{
        author.setPseudonimo("");
        author.setNombre("");
        assertThrows(IsPresentOrNull.class, ()->authorService.create(author));
    }

    @Test
    void update() throws Exception {
        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        when(authorRepository.save(author)).thenReturn(author);
        Author result = authorService.update(author.getId(),author);
        assertEquals(result, author);
    }

    @Test
    void daleteById() throws Exception {
        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        assertTrue(authorService.daleteById(author.getId()));
    }
}