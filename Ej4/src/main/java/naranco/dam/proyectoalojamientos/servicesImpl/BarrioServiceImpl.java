package naranco.dam.proyectoalojamientos.servicesImpl;

import naranco.dam.proyectoalojamientos.model.Barrios;
import naranco.dam.proyectoalojamientos.repository.BarrioRepo;
import naranco.dam.proyectoalojamientos.services.BarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarrioServiceImpl implements BarrioService {

    @Autowired
    private BarrioRepo barrioRepo;
    public Optional<Barrios> findBarriosById(Long id){
        return barrioRepo.findBarrioById(id);
    }
}
