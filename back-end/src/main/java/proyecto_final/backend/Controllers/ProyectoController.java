package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Proyecto;
import proyecto_final.backend.Services.ProyectoDb;

@RestController
public class ProyectoController {
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/proyecto/all")
    List<Proyecto> TodosLosProyectos(){
        return new ProyectoDb().ObtenerTodosLosProyectos();
    }
}
