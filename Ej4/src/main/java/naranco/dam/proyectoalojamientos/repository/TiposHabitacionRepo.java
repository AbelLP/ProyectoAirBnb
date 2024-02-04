package naranco.dam.proyectoalojamientos.repository;

import naranco.dam.proyectoalojamientos.model.Barrios;
import naranco.dam.proyectoalojamientos.model.TiposHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TiposHabitacionRepo extends JpaRepository<TiposHabitacion,Long> {
    @Query("SELECT t FROM TiposHabitacion t WHERE t.id=?1")
    Optional<TiposHabitacion> findTipoById(Long id);
}
