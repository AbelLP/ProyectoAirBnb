package naranco.dam.proyectoalojamientos.servicesImpl;

import naranco.dam.proyectoalojamientos.model.TiposHabitacion;
import naranco.dam.proyectoalojamientos.repository.TiposHabitacionRepo;
import naranco.dam.proyectoalojamientos.services.TiposHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TiposHabitacionesServiceImpl implements TiposHabitacionService {

    @Autowired
    private TiposHabitacionRepo tiposHabitacionRepo;

    public Optional<TiposHabitacion> findTipoById(Long id){
        return tiposHabitacionRepo.findTipoById(id);
    }
}
