package com.example.biblioteca.excepcion;

public class IsPresentOrNull extends RuntimeException{

    private String message;

    public IsPresentOrNull() {
    }

    public IsPresentOrNull(String message) {
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
