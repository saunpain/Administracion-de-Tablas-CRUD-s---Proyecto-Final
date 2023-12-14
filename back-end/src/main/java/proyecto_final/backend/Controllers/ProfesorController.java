package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Profesor;
import proyecto_final.backend.Services.ProfesorDb;

@RestController
public class ProfesorController {
    
    @GetMapping("/profesor/all")
    List<Profesor> TodasLosProfesores(){
        return new ProfesorDb().ObtenerTodosLosProfesores();
    }

    @DeleteMapping("/profesor/{codigoProfesor}")
    public int Delete(@PathVariable("codigoProfesor") String cprof){
        return new ProfesorDb().EliminarProfesor(cprof);
    }
}