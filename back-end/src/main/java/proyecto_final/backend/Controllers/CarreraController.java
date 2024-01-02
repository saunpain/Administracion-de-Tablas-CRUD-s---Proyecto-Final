package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Carrera;
import proyecto_final.backend.Services.CarreraDb;

@RestController
public class CarreraController {
    
    @GetMapping("/carreras/all")
    public List<Carrera> TodasLasCarreras(){
        return new CarreraDb().ObtenerTodasLasCarreras();
    }

    @PostMapping("/carreras")
    public int InsertarCarrera(@RequestBody Carrera carrera) {
        return new CarreraDb().GuardarCarrera(carrera);
    }

    @PutMapping("/carreras")
    public int ActualizarCarrera(@RequestBody Carrera carrera) {
        return new CarreraDb().ActualizarCarrera(carrera);
    }

    @DeleteMapping("/carreras/{codigo}")
    public int Delete(@PathVariable("codigo") String codigo){
        return new CarreraDb().EliminarCarrera(codigo);
    }
}
