package naranco.dam.proyectoalojamientos.repository;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlojamientosRepo extends JpaRepository<Alojamientos,Long>{

    @Query("SELECT a FROM Alojamientos a WHERE a.habitaciones=?1")
    List<Alojamientos> findAlojamientosByHabitacion(int habitaciones);

    @Query("SELECT a FROM Alojamientos a WHERE a.id=?1")
    Optional<Alojamientos> findAlojamientosById(Long id);

    @Query("SELECT a FROM Alojamientos a WHERE a.barrios.distritos.id=?1")
    List<Alojamientos> findAlojamientosByBarrio(Long id);

    @Query("SELECT a FROM Alojamientos a WHERE a.precio BETWEEN ?1 AND ?2")
    List<Alojamientos> findAlojamientosEntrePrecios(double precio1, double precio2);

    @Query("SELECT a FROM Alojamientos a WHERE a.barrios.distritos.id=?1 AND a.precio BETWEEN ?2 AND ?3")
    List<Alojamientos> findAlojamientosByBarrioAndEntrePrecios(Long id, double precio1, double precio2);

    @Query("SELECT a FROM Alojamientos a WHERE a.barrios.distritos.id=?1 AND a.habitaciones=?2")
    List<Alojamientos> findAlojamientosByBarriosAndHabitaciones(Long id, int habitacion);

    @Query("SELECT a FROM Alojamientos a WHERE a.barrios.distritos.id=?1 AND a.habitaciones=?2 AND a.banos=?3")
    List<Alojamientos> findAlojamientosByBarriosAndHabitacionesAndBanos(Long id, int habitacion, int banos);

}
