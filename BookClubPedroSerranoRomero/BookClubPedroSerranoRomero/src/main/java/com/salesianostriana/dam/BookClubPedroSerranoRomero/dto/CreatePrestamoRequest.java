package com.salesianostriana.dam.BookClubPedroSerranoRomero.dto;

import java.time.LocalDateTime;

public record CreatePrestamoRequest(
        Long usuario_id,
        Long libro_id,
        LocalDateTime fechaInicio
) {
}
