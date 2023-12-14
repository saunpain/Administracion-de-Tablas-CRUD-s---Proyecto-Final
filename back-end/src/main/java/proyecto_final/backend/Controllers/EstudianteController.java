package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Estudiante;
import proyecto_final.backend.Services.EstudianteDb;

@RestController
public class EstudianteController {

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/estudiante/all")
    List<Estudiante> TodosLosEstudiantes(){
        return new EstudianteDb().ObtenerTodosLosEstudiantes();
    }
}
