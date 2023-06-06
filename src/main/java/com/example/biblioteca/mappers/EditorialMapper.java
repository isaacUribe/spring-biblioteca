package com.example.biblioteca.mappers;

import com.example.biblioteca.domain.EditorialDto;

import com.example.biblioteca.entities.Editorial;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EditorialMapper {
    @Mappings({
            @Mapping(source = "id", target = "editorialId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description")
    })
    EditorialDto toEditorial (Editorial editorial);

    @InheritInverseConfiguration
    Editorial toEditorialDto (EditorialDto editorialDto);
}
