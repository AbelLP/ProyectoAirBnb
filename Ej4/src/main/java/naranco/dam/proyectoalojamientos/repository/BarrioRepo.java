package naranco.dam.proyectoalojamientos.repository;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.model.Barrios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BarrioRepo extends JpaRepository<Barrios, Long> {

    @Query("SELECT b FROM Barrios b WHERE b.id=?1")
    Optional<Barrios> findBarrioById(Long id);
}
