package com.example.biblioteca.excepcion;

public class EmailIncorrecto extends RuntimeException{
    private String message;

    public EmailIncorrecto() {
    }

    public EmailIncorrecto(String message) {
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
