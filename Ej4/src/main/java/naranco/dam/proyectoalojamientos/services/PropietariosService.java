package naranco.dam.proyectoalojamientos.services;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.model.Propietarios;

import java.util.Optional;

public interface PropietariosService {
    Optional<Propietarios> findPropietarioById(Long id);
}
