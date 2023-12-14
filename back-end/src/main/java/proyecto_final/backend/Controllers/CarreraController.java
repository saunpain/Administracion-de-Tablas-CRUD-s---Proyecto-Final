package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Carrera;
import proyecto_final.backend.Services.CarreraDb;

@RestController
public class CarreraController {
    
    @GetMapping("/carreras/all")
    public List<Carrera> TodasLasCarreras(){
        return new CarreraDb().ObtenerTodasLasCarreras();
    }

    @DeleteMapping("/carreras/{codigoCarrera}")
    public int Delete(@PathVariable("codigoCarrera") String cc){
        return new CarreraDb().EliminarCarrera(cc);
    }
}
