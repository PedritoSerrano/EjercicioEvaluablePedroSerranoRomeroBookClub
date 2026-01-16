package com.salesianostriana.dam.BookClubPedroSerranoRomero.repository;

import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {



}
