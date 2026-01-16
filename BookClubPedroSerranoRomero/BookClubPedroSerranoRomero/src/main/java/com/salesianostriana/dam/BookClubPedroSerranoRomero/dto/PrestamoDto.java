package com.salesianostriana.dam.BookClubPedroSerranoRomero.dto;

import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Estado;

import java.time.LocalDateTime;

public record PrestamoDto (
        Long id,
        LocalDateTime fechaInicio,
        Estado estado,
        String tituloLibro
) {



}
