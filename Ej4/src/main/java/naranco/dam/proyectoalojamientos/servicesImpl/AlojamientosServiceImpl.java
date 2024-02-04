package naranco.dam.proyectoalojamientos.servicesImpl;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.repository.AlojamientosRepo;
import naranco.dam.proyectoalojamientos.services.AlojamientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientosServiceImpl implements AlojamientosService {

    @Autowired
    private AlojamientosRepo alojamientosRepo;

    @Override
    public List<Alojamientos> findAllAlojamientos(){
        return alojamientosRepo.findAll();
    }

    @Override
    public Optional<Alojamientos> findAlojamientosById(Long id){
        return alojamientosRepo.findAlojamientosById(id);
    }

    @Override
    public Alojamientos saveAlojamiento(Alojamientos alojamientos){
        if(alojamientos!=null){
            return alojamientosRepo.save(alojamientos);
        }else{
            return null;
        }
    }

    @Override
    public Alojamientos updateAlojamientos(Alojamientos alojamientos){
        if(alojamientosRepo.findById(alojamientos.getId()).isPresent()){
            return alojamientosRepo.save(alojamientos);
        }
        return null;
    }

    @Override
    public boolean borrarAlojamiento(Long id){
        Optional<Alojamientos> alojamientos=alojamientosRepo.findById(id);
        if(alojamientos.isPresent()){
            alojamientosRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Alojamientos> findAlojamientosByHabitacion(int habitacion){
        return alojamientosRepo.findAlojamientosByHabitacion(habitacion);
    }

    @Override
    public List<Alojamientos> findAlojamientosByBarrio(Long id){
        return alojamientosRepo.findAlojamientosByBarrio(id);
    }

    @Override
    public List<Alojamientos> findAlojamientosEntrePrecios(double precio1, double precio2){
        return alojamientosRepo.findAlojamientosEntrePrecios(precio1, precio2);
    }

    @Override
    public List<Alojamientos> findAlojamientosByBarrioAndEntrePrecios(Long id, double precio1, double precio2) {
        return alojamientosRepo.findAlojamientosByBarrioAndEntrePrecios(id, precio1, precio2);
    }

    @Override
    public List<Alojamientos> findAlojamientosByBarriosAndHabitaciones(Long id, int habitacion) {
        return alojamientosRepo.findAlojamientosByBarriosAndHabitaciones(id, habitacion);
    }

    @Override
    public List<Alojamientos> findAlojamientosByBarriosAndHabitacionesAndBanos(Long id, int habitacion, int banos) {
        return alojamientosRepo.findAlojamientosByBarriosAndHabitacionesAndBanos(id, habitacion, banos);
    }
}
