package com.example.biblioteca.mappers;

import com.example.biblioteca.domain.Country;
import com.example.biblioteca.entities.Pais;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CountryMapper {
    @Mappings({
            @Mapping(source = "idPais", target = "countryId"),
            @Mapping(source = "nombre", target = "name")
    })
    Country toCountry (Pais pais);

    @InheritInverseConfiguration
    @Mapping(target = "author", ignore = true)
    Pais toPais(Country country);

}
