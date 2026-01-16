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

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;

    @OneToMany
    private List<Prestamo> prestamo;

}
