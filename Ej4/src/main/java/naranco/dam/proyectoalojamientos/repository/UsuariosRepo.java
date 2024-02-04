package naranco.dam.proyectoalojamientos.repository;

import naranco.dam.proyectoalojamientos.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepo extends JpaRepository<Usuarios, Integer> {

    Usuarios findByNombreAndPassword(String nombre, String contrasena);
}
