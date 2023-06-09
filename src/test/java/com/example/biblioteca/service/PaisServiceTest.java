package com.example.biblioteca.service;

import com.example.biblioteca.entities.Pais;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.repository.PaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaisServiceTest {

    @Mock
    PaisRepository paisRepository;
    @InjectMocks
    PaisService paisService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_noPresente() throws Exception {
        Integer id = 1;
        String nombre = "pais ejemplo";

        Pais pais = new Pais(id, nombre);
        when(paisRepository.existsByNombre(pais.getNombre())).thenReturn(false);
        when(paisRepository.save(pais)).thenReturn(pais);
        Pais result = paisService.create(pais);
        assertNotNull(result);
        assertEquals(pais, result);
    }
    @Test
    void create_Presente() throws  Exception{
        Integer id = 1;
        String nombre = "pais ejemplo";

        Pais pais = new Pais(id, nombre);
        when(paisRepository.existsByNombre(pais.getNombre())).thenReturn(true);
        assertThrows(IsPresentOrNull.class,()->paisService.create(pais));
    }
}