package com.example.biblioteca.service;

import com.example.biblioteca.entities.Ubicacion;
import com.example.biblioteca.repository.UbicacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UbicacionServiceTest {

    @Mock
    UbicacionRepository ubicacionRepository;
    @InjectMocks
    UbicacionService ubicacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Integer id = 1;
        String piso = "tercero";
        String salon = "1A";
        String estante = "2B";
        Ubicacion ubicacion = new Ubicacion(id,piso,salon,estante);
        when(ubicacionRepository.save(ubicacion)).thenReturn(ubicacion);
        Ubicacion result = ubicacionService.create(ubicacion);
        assertEquals(result,ubicacion);
    }
}