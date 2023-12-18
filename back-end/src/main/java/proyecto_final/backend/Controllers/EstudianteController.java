package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(required = false) String identificacion,
            @RequestParam(required = false) String carrera,
            @RequestParam(required = false) String anio) {
        return new EstudianteDb().FiltrarEstudiantes(nombre, identificacion, carrera, anio);
    }

    @PostMapping("/estudiante")
    public int InsertarEstudiante(@RequestBody Estudiante estudiante) {
        return new EstudianteDb().GuardarEstudiante(estudiante);
    }

    @PutMapping("/estudiante")
    public int ActualizarEstudiante(@RequestBody Estudiante estudiante) {
        return new EstudianteDb().ActualizarEstudiante(estudiante);
    }

    @DeleteMapping("/estudiante/{cedula}")
    public int Delete(@PathVariable("cedula") String cedula){
        return new EstudianteDb().EliminarEstudiante(cedula);
    }
}
