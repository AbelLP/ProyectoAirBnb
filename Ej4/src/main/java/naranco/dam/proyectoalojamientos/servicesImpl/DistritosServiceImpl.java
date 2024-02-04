package naranco.dam.proyectoalojamientos.servicesImpl;

import naranco.dam.proyectoalojamientos.model.Distritos;
import naranco.dam.proyectoalojamientos.repository.DistritosRepo;
import naranco.dam.proyectoalojamientos.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritosServiceImpl implements DistritoService {

    @Autowired
    private DistritosRepo distritosRepo;

    public List<Distritos> findAllDistritos(){
        return distritosRepo.findAll();
    }

}
