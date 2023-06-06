package com.example.biblioteca.mappers;

import com.example.biblioteca.domain.Category;
import com.example.biblioteca.entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CategoriaMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description")
    })
    Category toCategory (Categoria categoria);
    @InheritInverseConfiguration
    Categoria toCategoria(Category category);
}
