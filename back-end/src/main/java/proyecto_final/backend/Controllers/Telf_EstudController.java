package proyecto_final.backend.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Telf_Estud;
import proyecto_final.backend.Services.Telf_EstudDb;

@RestController
public class Telf_EstudController{

    @GetMapping("/telefono/all")
    List<Telf_Estud> TodosLosTelefonos(){
        return new Telf_EstudDb().ObtenerTodosLosTelefonos();
    }
}