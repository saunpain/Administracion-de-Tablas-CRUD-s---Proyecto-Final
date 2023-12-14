package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Proyecto_profesor_sustenta;
import proyecto_final.backend.Services.Proyecto_profesor_sustentaDb;

@RestController
public class Proyecto_profesor_sustentaController{
    
    @GetMapping("/sustentaciones/all")
    List<Proyecto_profesor_sustenta> TodasLasSustentaciones(){
        return new Proyecto_profesor_sustentaDb().ObtenerTodasLasSustentaciones();
    }

    @DeleteMapping("/sustentaciones/{codigoProfesor}")
    public int Delete(@PathVariable("codigoProfesor") String cprof){
        return new Proyecto_profesor_sustentaDb().EliminarSustentaciones(cprof);
    }
}