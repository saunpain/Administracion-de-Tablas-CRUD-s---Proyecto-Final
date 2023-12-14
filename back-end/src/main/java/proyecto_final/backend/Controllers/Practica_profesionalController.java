package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import proyecto_final.backend.Models.Practica_profesional;
import proyecto_final.backend.Services.Practica_profesionalDb;

@RestController
public class Practica_profesionalController {

    @GetMapping("/practica/all")
    List<Practica_profesional> TodasLasPracticas(){
        return new Practica_profesionalDb().ObtenerTodasLasPracticas();
    }

    @DeleteMapping("/practica/{codigoProyecto}")
    public int Delete(@PathVariable("codigoProyecto") String cp){
        return new Practica_profesionalDb().EliminarPractica(cp);
    }
}
