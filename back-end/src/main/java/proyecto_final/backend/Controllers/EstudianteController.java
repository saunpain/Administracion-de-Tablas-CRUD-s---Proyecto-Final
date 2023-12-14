package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import proyecto_final.backend.Models.Estudiante;
import proyecto_final.backend.Services.EstudianteDb;

@RestController
public class EstudianteController {

    @GetMapping("/estudiante/all")
    List<Estudiante> TodosLosEstudiantes(){
        return new EstudianteDb().ObtenerTodosLosEstudiantes();
    }

    @DeleteMapping("/estudiante/{cedula}")
    public int Delete(@PathVariable("cedula") String cedula){
        return new EstudianteDb().EliminarEstudiante(cedula);
    }
}
