package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Proyecto;
import proyecto_final.backend.Services.ProyectoDb;

@RestController
public class ProyectoController {
    
    @GetMapping("/proyecto/all")
    List<Proyecto> TodosLosProyectos(){
        return new ProyectoDb().ObtenerTodosLosProyectos();
    }
}
