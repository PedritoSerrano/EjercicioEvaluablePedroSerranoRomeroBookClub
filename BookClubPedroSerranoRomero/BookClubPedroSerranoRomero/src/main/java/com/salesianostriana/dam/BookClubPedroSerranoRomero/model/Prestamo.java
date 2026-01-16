package com.salesianostriana.dam.BookClubPedroSerranoRomero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Prestamo {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fechaInicio;
    private Estado estado;

    @ManyToOne
    private Libro libro;

    @ManyToOne
    private Usuario usuario;

}
