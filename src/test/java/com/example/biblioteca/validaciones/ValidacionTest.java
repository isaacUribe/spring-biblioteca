package com.example.biblioteca.validaciones;

import com.example.biblioteca.excepcion.EmailIncorrecto;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.excepcion.NoEncontrado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionTest {


    @Test
    void validarLengthNombre() {
        String nombreCorrecto = "editorial";
        String nombreLargo = "Este es el nombre largo validacion qwertyuiopasdasdfdfgfgfgfg";
        String nombreUnSoloCaracter = "N";

        assertDoesNotThrow(()->Validacion.validarLengthNombre(nombreCorrecto));
        assertThrows(Exception.class, ()->Validacion.validarLengthNombre(nombreLargo));
        assertThrows(Exception.class, ()->Validacion.validarLengthNombre(nombreUnSoloCaracter));
    }
    @Test
    void validarLengthDescipcion() {
        String descripcionCorrecto = "esta es la descripcion de prueba";
        String descripcionErronea = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor h" +
                "endrerit turpis ut feugiat. Vivamus elementum nec mauris elementum ullamcorper. Etiam at elit" +
                " nisl. Cras non libero nulla. Proin fringilla maximus mauris, a consequat leo faucibus eu. Q" +
                "uisque in feugiat risus. In eu imperdiet ligula, in lacinia lectus. Nullam id justo quis lacus " +
                "posuere auctor. Ut ut consequat mi, sit amet nec.";
        assertDoesNotThrow(()->Validacion.validarLengthDescipcion(descripcionCorrecto));
        assertThrows(Exception.class, ()->Validacion.validarLengthDescipcion(descripcionErronea));
    }

    @Test
    void validarCampoYaEstaPresente_existeCampo() {
        boolean existCampo = true;
        String nombre = "Nombre ejemplo";
        assertThrows(IsPresentOrNull.class,()-> Validacion.validarCampoYaEstaPresente(existCampo, nombre));
    }
    @Test
    void validarCampoYaEstaPresente_campoVacio(){
        boolean existCampo = false;
        String nombre = "";
        assertThrows(IsPresentOrNull.class, ()->Validacion.validarCampoYaEstaPresente(existCampo,nombre));
    }
    @Test
    void validarCampoYaEstaPresente(){
        boolean existCampo = false;
        String nombre = "Nombre prueba";
        assertDoesNotThrow(()->Validacion.validarCampoYaEstaPresente(existCampo, nombre));
    }

    @Test
    void validarSiEstaPorElId_idPresente() {
        Optional<Integer> id = Optional.of(1);
        assertDoesNotThrow(()->Validacion.validarSiEstaPorElId(id));
    }
    @Test
    void validarSiEstaPorElId_idNoPresente(){
        Optional<Integer> id = Optional.empty();
        assertThrows(NoEncontrado.class, ()->Validacion.validarSiEstaPorElId(id));
    }

    @Test
    void validarEmail() {
        String emailCorrecto = "emailprueba@gmail.com";
        String emailIncorrecto = "emailprueba";
        String emailIncorrecto2 = "emailprueba@gmailcom";
        assertThrows(EmailIncorrecto.class, ()->Validacion.validarEmail(emailIncorrecto));
        assertThrows(EmailIncorrecto.class, ()->Validacion.validarEmail(emailIncorrecto2));
        assertDoesNotThrow(()-> Validacion.validarEmail(emailCorrecto));
    }
}