package com.salesianostriana.dam.BookClubPedroSerranoRomero.controller;

import com.salesianostriana.dam.BookClubPedroSerranoRomero.dto.CreatePrestamoRequest;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.PrestamoRepository;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final PrestamoRepository prestamoRepository;

    @PostMapping
    public void crear(CreatePrestamoRequest dto){
        prestamoService.createPrestamo(dto);
    }

    @PutMapping("/{id}/devolver")
    public void devolver(@PathVariable Long id) {
        prestamoService.devolverPrestamo(id);
    }

}
