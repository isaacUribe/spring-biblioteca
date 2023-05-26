package com.example.biblioteca.excepcion;

public class DescripcionExecpcion extends RuntimeException{

    private String message;

    public DescripcionExecpcion(String message) {
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
