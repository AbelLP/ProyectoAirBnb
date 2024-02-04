package naranco.dam.proyectoalojamientos.repository;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.model.Barrios;
import naranco.dam.proyectoalojamientos.model.Propietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PropietariosRepo extends JpaRepository<Propietarios, Long> {

    @Query("SELECT p FROM Propietarios p WHERE p.id=?1")
    Optional<Propietarios> findPropietarioById(Long id);
}
