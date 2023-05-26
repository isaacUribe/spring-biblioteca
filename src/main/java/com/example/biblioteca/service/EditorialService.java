package com.example.biblioteca.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.excepcion.DescripcionExecpcion;
import com.example.biblioteca.excepcion.IsPresentOrNull;
import com.example.biblioteca.excepcion.NameExecpcion;
import com.example.biblioteca.excepcion.NoEncontrado;
import com.example.biblioteca.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.util.List;
import java.util.Optional;

@Service

public class EditorialService implements BaseService<Editorial>{

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> findAll() throws Exception{
        try {
            List<Editorial> editorials = editorialRepository.findAll();
            return editorials;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Editorial findById(Integer id) throws Exception {
        try{
            Optional<Editorial> editorial = editorialRepository.findById(id);
            return editorial.get();
        }catch (Exception e){
            throw new NoEncontrado("El editorial no ha sido encontrado");
        }
    }

    @Override
    public Editorial create(Editorial datosRegistrar) throws Exception {

            boolean existeEditorial = editorialRepository.existsByNombre(datosRegistrar.getNombre());


            if (datosRegistrar.getNombre().length() > 30 || datosRegistrar.getNombre().length() < 2  ){
                throw new NameExecpcion("Solo se permite un nombre menor que los 30 caracteres y mayor que los 2 caracteres");
            } else if (datosRegistrar.getDescripcion().length() > 300) {
                throw  new DescripcionExecpcion("La descripcion sobrepasa los 300 caracteres");
            } else if (existeEditorial || datosRegistrar.getNombre() == null) {
                throw  new IsPresentOrNull("el nombre ya esta presente o el campo esta vacio");
            }

            Editorial editorial = editorialRepository.save(datosRegistrar);
            return editorial;


    }

    @Override
    public Editorial update(Integer id, Editorial datosNuevos) throws Exception {
            Optional<Editorial> editorialOptional = editorialRepository.findById(id);
            if(editorialOptional.isPresent()){
                Editorial editorialExistente = editorialOptional.get();
                editorialExistente.setNombre(datosNuevos.getNombre());
                editorialExistente.setDescripcion(datosNuevos.getDescripcion());
                Editorial editorialActualizado = editorialRepository.save(editorialExistente);
                return editorialActualizado;
            }else{
                throw new NoEncontrado("Editorial no encontrado");
            }

    }

    @Override
    public boolean daleteById(Integer id) throws Exception {

            Optional<Editorial> editorialOptional = editorialRepository.findById(id);
            if (editorialOptional.isPresent()){
                editorialRepository.deleteById(id);
                return true;
            }else{
                throw new NoEncontrado("Editorial no encontrado");
            }

    }

}
