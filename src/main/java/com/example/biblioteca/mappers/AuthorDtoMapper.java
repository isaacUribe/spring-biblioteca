package com.example.biblioteca.mappers;

import com.example.biblioteca.domain.AuthorDto;
import com.example.biblioteca.entities.Author;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface  AuthorDtoMapper {
    @Mappings({
            @Mapping(source = "id", target = "authorId"),
            @Mapping(source = "idPais", target = "countryId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "pseudonimo", target = "pseudonym"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "pais", target = "country")
    })
    AuthorDto toAuthorDto (Author author);
    @InheritInverseConfiguration
    Author toAuthor(AuthorDto authorDto);
}
