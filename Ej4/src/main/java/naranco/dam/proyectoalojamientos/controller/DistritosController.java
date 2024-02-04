package naranco.dam.proyectoalojamientos.controller;

import naranco.dam.proyectoalojamientos.model.Distritos;
import naranco.dam.proyectoalojamientos.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistritosController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/distritos")
    public List<Distritos> findAllDistritos(){
        return distritoService.findAllDistritos();
    }

}
