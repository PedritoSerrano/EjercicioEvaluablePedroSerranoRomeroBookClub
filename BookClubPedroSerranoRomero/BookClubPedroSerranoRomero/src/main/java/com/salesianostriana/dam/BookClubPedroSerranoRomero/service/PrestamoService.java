package com.salesianostriana.dam.BookClubPedroSerranoRomero.service;

import com.salesianostriana.dam.BookClubPedroSerranoRomero.dto.CreatePrestamoRequest;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Estado;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Libro;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Prestamo;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.LibroRepository;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.PrestamoRepository;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private UsuarioRepository usuarioRepository;
    private LibroRepository libroRepository;
    private PrestamoRepository prestamoRepository;

    public void createPrestamo (CreatePrestamoRequest dto) {
        Libro libro = libroRepository.findById(dto.libro_id())
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado"));

        if (libro.getEjemplaresDisponibles() <= 0){
            throw new IllegalArgumentException("No hay ejemplares disponibles de este libro");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setEstado(Estado.ACTIVO);
        prestamo.setFechaInicio(dto.fechaInicio());
        prestamo.setUsuario(usuarioRepository.getReferenceById(dto.usuario_id()));
        prestamo.setLibro(libro);

        libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() - 1);

        prestamoRepository.save(prestamo);
    }

    public void devolverPrestamo (Long prestamo_id) {

        Prestamo prestamo = prestamoRepository.findById(prestamo_id)
                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado"));

        if (prestamo.getEstado() == Estado.DEVUELTO){
            throw new IllegalArgumentException("Este libro ya ha sido devuelto");
        }

        prestamo.setEstado(Estado.DEVUELTO);

        Libro libro = prestamo.getLibro();

        libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() +1 );

    }

}
