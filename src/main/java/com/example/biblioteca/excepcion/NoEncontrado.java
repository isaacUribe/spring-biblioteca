package com.example.biblioteca.excepcion;


public class NoEncontrado extends RuntimeException{

    private String message;

    public NoEncontrado() {
    }

    public NoEncontrado(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
