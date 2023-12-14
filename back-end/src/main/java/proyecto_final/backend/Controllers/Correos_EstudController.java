package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Correo_Estud;
import proyecto_final.backend.Services.Correo_EstudDb;

@RestController
public class Correos_EstudController {
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/correosEstudiantes/all")
    List<Correo_Estud> TodosLosCorreos(){
        return new Correo_EstudDb().ObtenerTodosLosCorreos();
    }
}
