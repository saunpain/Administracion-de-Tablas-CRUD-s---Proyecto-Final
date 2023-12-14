package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Practica_profesional;
import proyecto_final.backend.Services.Practica_profesionalDb;

@RestController
public class Practica_profesionalController {

    @CrossOrigin(origins = "http://127.0.0.1:5500/") 
    @GetMapping("/practica/all")
    List<Practica_profesional> TodasLasPracticas(){
        return new Practica_profesionalDb().ObtenerTodasLasPracticas();
    }
}
