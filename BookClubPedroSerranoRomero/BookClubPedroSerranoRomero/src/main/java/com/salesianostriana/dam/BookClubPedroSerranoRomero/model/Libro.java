package com.salesianostriana.dam.BookClubPedroSerranoRomero.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;

    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
    private List<Prestamo> prestamo = new ArrayList<>();

}
