package naranco.dam.proyectoalojamientos.services;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.model.TiposHabitacion;

import java.util.Optional;

public interface TiposHabitacionService {
    Optional<TiposHabitacion> findTipoById(Long id);
}
