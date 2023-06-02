package com.example.biblioteca.validaciones;

import com.example.biblioteca.excepcion.*;

import java.util.Optional;

public class Validacion {
    public static void validarLengthNombre (String nombre) {
        if (nombre.length() > 30 || nombre.length() < 2) {
            throw new NameExecpcion("Solo se permite un nombre menor que los 30 caracteres y mayor que los 2 caracteres");
        }
    }
    public static void validarLengthDescipcion (String descipcion){
        if (descipcion.length() > 300) {
            throw  new DescripcionExecpcion("La descripcion sobrepasa los 300 caracteres");
        }
    }
    public static void validarCampoYaEstaPresente(boolean existCampo,String nombre){
        if (existCampo || nombre.isEmpty()) {
            throw  new IsPresentOrNull("el nombre ya esta presente o el campo esta vacio");
        }
    }
    public static void validarSiEstaPorElId(Optional<?> id){
        if(!id.isPresent()){{
            throw new NoEncontrado("Author no encontrado");
        }}
    }
    public static void validarEmail(String email){
        String emailValidator = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if(!email.matches(emailValidator)){
            throw new EmailIncorrecto("El email es incorrecto");
        }
    }
}
