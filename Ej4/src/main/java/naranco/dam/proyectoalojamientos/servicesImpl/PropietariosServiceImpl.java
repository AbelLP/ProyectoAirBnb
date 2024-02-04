package naranco.dam.proyectoalojamientos.servicesImpl;

import naranco.dam.proyectoalojamientos.model.Propietarios;
import naranco.dam.proyectoalojamientos.repository.PropietariosRepo;
import naranco.dam.proyectoalojamientos.services.PropietariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropietariosServiceImpl implements PropietariosService {

    @Autowired
    private PropietariosRepo propietariosRepo;

    public Optional<Propietarios> findPropietarioById(Long id){
        return propietariosRepo.findPropietarioById(id);
    }
}
