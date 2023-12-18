package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Practica_profesional;
import proyecto_final.backend.Services.Practica_profesionalDb;

@RestController
public class Practica_profesionalController {

    @GetMapping("/practica/all")
    List<Practica_profesional> TodasLasPracticas(){
        return new Practica_profesionalDb().ObtenerTodasLasPracticas();
    }

    @DeleteMapping("/practica/{codigoProyecto}")
    public int Delete(@PathVariable("codigoProyecto") String cp){
        return new Practica_profesionalDb().EliminarPractica(cp);
    }
    @PostMapping("/practica")
    public int InsertarPractica(@RequestBody Practica_profesional practica_Profesional) {
        return new Practica_profesionalDb().GuardarPractica(practica_Profesional);
    }

    @PutMapping("/practica")
    public int ActualizarPractica(@RequestBody Practica_profesional practica_profesional) {
        return new Practica_profesionalDb().ActualizarPractica(practica_profesional);
    }
}
