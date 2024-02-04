package naranco.dam.proyectoalojamientos.services;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.model.Barrios;

import java.util.Optional;

public interface BarrioService {
    Optional<Barrios> findBarriosById(Long id);
}
