package com.salesianostriana.dam.BookClubPedroSerranoRomero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;

    @OneToMany
    private List<Prestamo> prestamo;

}
