package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Supervisor;
import proyecto_final.backend.Services.SupervisorDb;

@RestController
public class SupervisorController {

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/supervisor/all")
    List<Supervisor> TodosLosSupervisores(){
        return new SupervisorDb().ObtenerTodosLosSupervisores();
    }
}
