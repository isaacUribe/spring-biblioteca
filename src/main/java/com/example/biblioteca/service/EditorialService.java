package com.example.biblioteca.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.biblioteca.entities.Editorial;
import com.example.biblioteca.repository.EditorialRepository;
import com.example.biblioteca.validaciones.Validacion;
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
            Optional<Editorial> editorial = editorialRepository.findById(id);
            Validacion.validarSiEstaPorElId(editorial);
            return editorial.get();

    }

    @Override
    public Editorial create(Editorial datosRegistrar) throws Exception {
            String nombre = datosRegistrar.getNombre();
            String descipcion = datosRegistrar.getDescripcion();
            boolean existeEditorial = editorialRepository.existsByNombre(datosRegistrar.getNombre());


            Validacion.validarLengthNombre(nombre);
            Validacion.validarLengthDescipcion(descipcion);
            Validacion.validarCampoYaEstaPresente(existeEditorial,nombre);


            Editorial editorial = editorialRepository.save(datosRegistrar);
            return editorial;


    }

    @Override
    public Editorial update(Integer id, Editorial datosNuevos) throws Exception {
            Optional<Editorial> editorialOptional = editorialRepository.findById(id);
            Validacion.validarSiEstaPorElId(editorialOptional);
                Editorial editorialExistente = editorialOptional.get();
                editorialExistente.setNombre(datosNuevos.getNombre());
                editorialExistente.setDescripcion(datosNuevos.getDescripcion());
                Editorial editorialActualizado = editorialRepository.save(editorialExistente);
                return editorialActualizado;

    }

    @Override
    public boolean daleteById(Integer id) throws Exception {

            Optional<Editorial> editorialOptional = editorialRepository.findById(id);
            Validacion.validarSiEstaPorElId(editorialOptional);
                editorialRepository.deleteById(id);
                return true;

    }

}
