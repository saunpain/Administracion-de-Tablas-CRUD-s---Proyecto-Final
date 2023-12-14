package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import proyecto_final.backend.Models.Correo_Estud;
import proyecto_final.backend.Services.Correo_EstudDb;

@RestController
public class Correos_EstudController {
    
    @GetMapping("/correosEstudiantes/all")
    List<Correo_Estud> TodosLosCorreos(){
        return new Correo_EstudDb().ObtenerTodosLosCorreos();
    }

    @DeleteMapping("/correosEstudiantes/{cedula}")
    public int Delete(@PathVariable("cedula") String cedula){
        return new Correo_EstudDb().EliminarCorreoEstudiante(cedula);
    }
}
