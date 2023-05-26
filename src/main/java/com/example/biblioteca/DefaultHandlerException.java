package com.example.biblioteca;

import com.example.biblioteca.excepcion.DescripcionExecpcion;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.excepcion.NameExecpcion;
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
}
