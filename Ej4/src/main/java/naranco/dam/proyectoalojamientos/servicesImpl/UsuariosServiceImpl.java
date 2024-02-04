package naranco.dam.proyectoalojamientos.servicesImpl;

import naranco.dam.proyectoalojamientos.model.Usuarios;
import naranco.dam.proyectoalojamientos.repository.UsuariosRepo;
import naranco.dam.proyectoalojamientos.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Override
    public Usuarios findByNombreAndPassword(String nombre, String password){
        return usuariosRepo.findByNombreAndPassword(nombre, password);
    }
}
