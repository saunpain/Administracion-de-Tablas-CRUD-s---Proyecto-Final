package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Supervisor;
import proyecto_final.backend.Services.SupervisorDb;

@RestController
public class SupervisorController {

    @GetMapping("/supervisor/all")
    List<Supervisor> TodosLosSupervisores(){
        return new SupervisorDb().ObtenerTodosLosSupervisores();
    }
    
    @PostMapping("/supervisor")
    public int InsertarSupervisor(@RequestBody Supervisor supervisor) {
        return new SupervisorDb().GuardarSupervisor(supervisor);
    }

    @PutMapping("/supervisor")
    public int ActualizarSupervisor(@RequestBody Supervisor supervisor) {
        return new SupervisorDb().ActualizarSupervisor(supervisor);
    }

    @DeleteMapping("/supervisor/{codigoSupervisor}")
    public int Delete(@PathVariable("codigoSupervisor") String csuperv){
        return new SupervisorDb().EliminarSupervisor(csuperv);
    }
    
}
