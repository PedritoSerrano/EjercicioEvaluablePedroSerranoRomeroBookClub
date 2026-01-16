package com.salesianostriana.dam.BookClubPedroSerranoRomero.service;

import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.LibroRepository;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.PrestamoRepository;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibroService {

    private UsuarioRepository usuarioRepository;
    private LibroRepository libroRepository;
    private PrestamoRepository prestamoRepository;


}
