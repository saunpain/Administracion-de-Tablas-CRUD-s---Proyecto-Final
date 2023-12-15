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

    @GetMapping("/estudiante/filtrar")
    public List<Estudiante> FiltrarEstudiantes(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String carrera,
        @RequestParam(required = false) String identificacion,
        @RequestParam(required = false) String anio
    ) {
        return new EstudianteDb().FiltrarEstudiantes(nombre, carrera, identificacion, anio);
    }

    @DeleteMapping("/estudiante/{cedula}")
    public int Delete(@PathVariable("cedula") String cedula){
        return new EstudianteDb().EliminarEstudiante(cedula);
    }
}
