package com.example.biblioteca.service;

import java.util.List;

public interface BaseService<E> {

    public List<E> findAll() throws Exception;
    public E findById(Integer id) throws Exception;
    public E create (E datosRegistrar) throws  Exception;
    public E update (Integer id, E datosNuevos) throws  Exception;
    public boolean daleteById(Integer id) throws Exception;
}
