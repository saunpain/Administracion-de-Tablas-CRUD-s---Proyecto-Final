package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Proyecto_profesor_sustenta;
import proyecto_final.backend.Services.Proyecto_profesor_sustentaDb;

@RestController
public class Proyecto_profesor_sustentaController{
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/sustentaciones/all")
    List<Proyecto_profesor_sustenta> TodasLasSustentaciones(){
        return new Proyecto_profesor_sustentaDb().ObtenerTodasLasSustentaciones();
    }
}