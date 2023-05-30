package com.example.biblioteca;

import com.example.biblioteca.excepcion.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class DefaultHandlerException  extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> nameExepcion (NameExecpcion execpcion){
        return new ResponseEntity<String>( execpcion.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> descripcionExcepcion(DescripcionExecpcion execpcion){
        return new ResponseEntity<String>(execpcion.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> isPresentOrNull(IsPresentOrNull execpcion){
        return new ResponseEntity<String>(execpcion.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<String> noEncontrado(NoEncontrado encontrado){
        return new ResponseEntity<String>(encontrado.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<String> emailIncorrecto(EmailIncorrecto incorrecto){
        return new ResponseEntity<String>(incorrecto.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
