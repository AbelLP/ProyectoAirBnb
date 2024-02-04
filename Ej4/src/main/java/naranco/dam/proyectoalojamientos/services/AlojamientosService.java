package naranco.dam.proyectoalojamientos.services;

import naranco.dam.proyectoalojamientos.model.Alojamientos;

import java.util.List;
import java.util.Optional;

public interface AlojamientosService{

    List<Alojamientos> findAllAlojamientos();

    Optional<Alojamientos> findAlojamientosById(Long id);

    Alojamientos saveAlojamiento(Alojamientos alojamiento);

    boolean borrarAlojamiento(Long id);

    Alojamientos updateAlojamientos(Alojamientos alojamientos);

    List<Alojamientos> findAlojamientosByHabitacion(int habitaciones);

    List<Alojamientos> findAlojamientosByBarrio(Long id);

    List<Alojamientos> findAlojamientosEntrePrecios(double precio1, double precio2);

    List<Alojamientos> findAlojamientosByBarrioAndEntrePrecios(Long id, double precio1, double precio2);

    List<Alojamientos> findAlojamientosByBarriosAndHabitaciones(Long id, int habitacion);

    List<Alojamientos> findAlojamientosByBarriosAndHabitacionesAndBanos(Long id, int habitacion, int banos);
}
