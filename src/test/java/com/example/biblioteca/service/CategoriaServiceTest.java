package com.example.biblioteca.service;

import com.example.biblioteca.entities.Categoria;
import com.example.biblioteca.entities.Pais;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoriaServiceTest {
    @Mock
    CategoriaRepository categoriaRepository;
    @InjectMocks
    CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_noPresente() throws Exception {
        Integer id = 1;
        String nombre = "categoria ejemplo";
        String descripcion = "Ejemplo de descripcion";

        Categoria categoria = new Categoria(id, nombre, descripcion);
        when(categoriaRepository.existsByNombre(categoria.getNombre())).thenReturn(false);
        when(categoriaRepository.save(categoria)).thenReturn(categoria);
        Categoria result = categoriaService.create(categoria);
        assertNotNull(result);
        assertEquals(categoria, result);
    }
    @Test
    void create_Presente() throws  Exception{
        Integer id = 1;
        String nombre = "categoria ejemplo";
        String descripcion = "Ejemplo de descripcion";

        Categoria categoria = new Categoria(id, nombre, descripcion);
        when(categoriaRepository.existsByNombre(categoria.getNombre())).thenReturn(true);
        assertThrows(IsPresentOrNull.class,()->categoriaService.create(categoria));
    }
}