package com.example.biblioteca.service;

import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.repository.EditorialRepository;
import com.example.biblioteca.validaciones.Validacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditorialServiceTest {

    @Mock
    private EditorialRepository editorialRepository;

    @InjectMocks
    private EditorialService editorialService;

    private Editorial editorial;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        editorial = new Editorial();
        editorial.setId(1);
        editorial.setNombre("La bestia");
        editorial.setDescripcion("The beast editorial");
    }

    @Test
    void findAll() throws Exception {
        when(editorialRepository.findAll()).thenReturn(Arrays.asList(editorial));
        assertNotNull(editorialService.findAll());
    }

    @Test
    void findAllWithError() throws Exception{
        when(editorialRepository.findAll()).thenThrow(new RuntimeException("Error al obtener editoriales"));
        try{
            List<Editorial> result = editorialService.findAll();
        }catch (Exception e){
            assertEquals("Error al obtener editoriales", e.getMessage());
            verify(editorialRepository, times(1)).findAll();
            return;
        }
        throw new AssertionError("se esperaba una excepcion");
    }
    @Test
    void findById() throws Exception {
        Integer id = 1;
        Editorial editorialEsperada = new Editorial();
        editorialEsperada.setId(id);
        when(editorialRepository.findById(id)).thenReturn(Optional.of(editorialEsperada));
        Editorial result = editorialService.findById(1);
        assertEquals(editorialEsperada, result);
    }
    @Test
    void validarSiEstaPorElId() throws Exception{
        Optional<Editorial> editorialVacia = Optional.empty();
        Optional<Editorial> editorialNoVacia = Optional.of(mock(Editorial.class));

        assertThrows(Exception.class, () -> Validacion.validarSiEstaPorElId(editorialVacia));
        assertDoesNotThrow(()->Validacion.validarSiEstaPorElId(editorialNoVacia));
    }
    @Test
    void testCrear () throws Exception{
        String nombre = "Editorial test";
        String descripcion = "Esta es la descripcion";
        Editorial datosRegistrar = new Editorial(1,nombre, descripcion);
        when(editorialRepository.existsByNombre(nombre)).thenReturn(false);
        when(editorialRepository.save(datosRegistrar)).thenReturn(datosRegistrar);

        Editorial result = editorialService.create(datosRegistrar);
        assertEquals(result, datosRegistrar);

    }
    @Test
    void testEliminar() throws Exception{
        Integer id = 1;
        Optional<Editorial> editorialOptional = Optional.of(new Editorial(id, "Editorial prueba", "Esta es la decripcion de la editorial"));
        when(editorialRepository.findById(id)).thenReturn(editorialOptional);

        boolean result = editorialService.daleteById(id);
        assertTrue(result);
    }
    @Test
    void testActualizar() throws Exception{
        String nombre = "Editorial test";
        String descripcion = "Esta es la descripcion";
        Integer id = 1;
        Editorial datosRegistrar = new Editorial(id,nombre, descripcion);
        when(editorialRepository.findById(id)).thenReturn(Optional.of(datosRegistrar));
        when(editorialRepository.save(datosRegistrar)).thenReturn(datosRegistrar);
        Editorial result = editorialService.update(id,datosRegistrar);
        assertEquals(result, datosRegistrar);

    }

}