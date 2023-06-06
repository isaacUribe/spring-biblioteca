package com.example.biblioteca.mappers;

import com.example.biblioteca.domain.Location;
import com.example.biblioteca.entities.Ubicacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface LocationMapper {
    @Mappings({
            @Mapping(source = "idUbicacion", target = "locationId"),
            @Mapping(source = "piso", target = "floor"),
            @Mapping(source = "salon", target = "lounge"),
            @Mapping(source = "estante", target = "shlef")
    })
    Location toLocation (Ubicacion ubicacion);

    Ubicacion toUbicacion (Location location);
}
