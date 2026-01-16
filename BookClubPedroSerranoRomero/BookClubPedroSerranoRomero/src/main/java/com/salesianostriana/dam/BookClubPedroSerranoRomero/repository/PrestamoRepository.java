package com.salesianostriana.dam.BookClubPedroSerranoRomero.repository;

import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Estado;
import com.salesianostriana.dam.BookClubPedroSerranoRomero.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    List<Prestamo> findByUsuarioAndEstado(Long usuario_id, Estado estado);

    @Query("SELECT p FROM Prestamo p " +
            "JOIN FETCH p.libro " +
            "JOIN FETCH p.usuario " +
            "WHERE p.estado = :estado")
    List<Prestamo> findAllWithLibroAndUsuarioByEstado(@Param("estado") Estado estado);

}
