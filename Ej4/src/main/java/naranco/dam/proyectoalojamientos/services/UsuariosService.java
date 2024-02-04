package naranco.dam.proyectoalojamientos.services;

import naranco.dam.proyectoalojamientos.model.Usuarios;

public interface UsuariosService {

    Usuarios findByNombreAndPassword(String nombre, String password);
}
