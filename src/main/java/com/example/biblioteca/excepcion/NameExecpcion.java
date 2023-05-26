package com.example.biblioteca.excepcion;

public class NameExecpcion extends RuntimeException{
    private String message = "Sobrepasa los caracteres";

    public NameExecpcion() {
    }

    public NameExecpcion(String message) {
        super();
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
