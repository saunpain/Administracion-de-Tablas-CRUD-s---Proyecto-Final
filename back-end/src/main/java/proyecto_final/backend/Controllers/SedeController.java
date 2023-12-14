package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Sede;
import proyecto_final.backend.Services.SedeDb;

@RestController
public class SedeController{
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/sede/all")
    List<Sede> TodasLasSedes(){
        return new SedeDb().ObtenerTodasLasSedes();
    }

}