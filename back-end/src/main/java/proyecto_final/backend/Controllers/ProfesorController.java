package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Profesor;
import proyecto_final.backend.Services.ProfesorDb;

@RestController
public class ProfesorController {
    
    @GetMapping("/profesor/all")
    List<Profesor> TodasLosProfesores(){
        return new ProfesorDb().ObtenerTodosLosProfesores();
    }
}