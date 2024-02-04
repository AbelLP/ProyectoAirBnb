package naranco.dam.proyectoalojamientos.controller;

import naranco.dam.proyectoalojamientos.model.Alojamientos;
import naranco.dam.proyectoalojamientos.model.Barrios;
import naranco.dam.proyectoalojamientos.model.Propietarios;
import naranco.dam.proyectoalojamientos.model.TiposHabitacion;
import naranco.dam.proyectoalojamientos.services.AlojamientosService;
import naranco.dam.proyectoalojamientos.services.BarrioService;
import naranco.dam.proyectoalojamientos.services.PropietariosService;
import naranco.dam.proyectoalojamientos.services.TiposHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
public class AlojamientosController extends AbstractController{

    static Scanner teclado=new Scanner(System.in);

    @Autowired
    private AlojamientosService alojamientosService;

    @Autowired
    private BarrioService barrioService;

    @Autowired
    private TiposHabitacionService tiposHabitacionService;

    @Autowired
    private PropietariosService propietariosService;

    @GetMapping("/alojamiento")
    public List<Alojamientos> getAlojamientos(){
        return alojamientosService.findAllAlojamientos();
    }

    @PostMapping("/alojamiento")
    public ResponseEntity<Alojamientos> addAlojamientos(@RequestHeader String authorization){
        comprobarAutorizacion(authorization);
        Long barrio_id=2L;
        Optional<Barrios> barrio=barrioService.findBarriosById(barrio_id);
        Long tiposHabitacion_id=5L;
        Optional<TiposHabitacion> tipos=tiposHabitacionService.findTipoById(tiposHabitacion_id);
        Long propietarios_id=1L;
        Optional<Propietarios> propietarios=propietariosService.findPropietarioById(propietarios_id);
        if(barrio.isPresent()&&tipos.isPresent()&&propietarios.isPresent()){
            Alojamientos alojamientos=new Alojamientos();
            alojamientos.setAseos((int)Math.random()*10+1);
            alojamientos.setBanos((int)Math.random()*10+1);
            alojamientos.setCamas((int)Math.random()*10+1);
            alojamientos.setLatitud((int)Math.random()*10+1);
            alojamientos.setLongitud((int)Math.random()*10+1);
            alojamientos.setNombre("Nuevo"+((int) Math.random()*10+1));
            alojamientos.setPrecio(Math.random()*1000+1);
            alojamientos.setPuntuacion(Math.random()+10*1);
            alojamientos.setPropietario(propietarios.get());
            alojamientos.setTiposHabitacion(tipos.get());
            alojamientos.setBarrios(barrio.get());

            System.out.println(alojamientos);

            return new ResponseEntity<>(alojamientosService.saveAlojamiento(alojamientos),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/alojamiento")
    public ResponseEntity<Alojamientos>updateAlojamientos(@RequestBody Alojamientos alojamientos, @RequestHeader String authorization){
        comprobarAutorizacion(authorization);
        Alojamientos alojamientosUpdated=alojamientosService.updateAlojamientos(alojamientos);
        if(alojamientosUpdated!=null){
            return new ResponseEntity<>(alojamientosUpdated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/alojamiento/{id}")
    public String borrarAlojamientos(@PathVariable Long id){
        if(alojamientosService.borrarAlojamiento(id)){
            return "El alojamiento ha sido eliminado correctamente.";
        }else{
            return "El alojamiento no existe.";
        }
    }

    @GetMapping("/alojamiento/distrito/{id}")
    public List<Alojamientos> findAlojamientosByBarrio(@PathVariable Long id){
        return alojamientosService.findAlojamientosByBarrio(id);
    }

    @GetMapping("/alojamiento/distrito/{id}/min/{precio1}/max/{precio2}")
    public List<Alojamientos> findAlojamientosByBarrioAndEntrePrecio(@PathVariable Long id, @PathVariable double precio1, @PathVariable double precio2){
        return alojamientosService.findAlojamientosByBarrioAndEntrePrecios(id, precio1, precio2);
    }

    @GetMapping("/alojamiento/distrito/{id}/habitaciones/{habitacion}")
    public List<Alojamientos> findAlojamientosByBarriosAndHabitaciones(@PathVariable Long id,@PathVariable int habitacion){
        return alojamientosService.findAlojamientosByBarriosAndHabitaciones(id, habitacion);
    }

    @GetMapping("/alojamiento/distrito/{id}/habitaciones/{habitacion}/banos/{banos}")
    public List<Alojamientos> findAlojamientosByBarriosAndHabitacionAndBanos(@PathVariable Long id, @PathVariable int habitacion, @PathVariable int banos){
        return alojamientosService.findAlojamientosByBarriosAndHabitacionesAndBanos(id, habitacion, banos);
    }

    @GetMapping("/alojamiento/habitacion/{habitacion}")
    public List<Alojamientos> findAlojamientosByHabitacion(@PathVariable int habitacion){
        return alojamientosService.findAlojamientosByHabitacion(habitacion);
    }

    @GetMapping("/alojamiento/min/{precio1}/max/{precio2}")
    public List<Alojamientos> findAlojamientosEntrePrecios(@PathVariable double precio1, @PathVariable double precio2){
        return alojamientosService.findAlojamientosEntrePrecios(precio1, precio2);
    }







}
