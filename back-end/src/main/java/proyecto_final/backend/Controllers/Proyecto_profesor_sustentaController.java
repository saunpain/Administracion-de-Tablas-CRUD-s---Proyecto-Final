package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Proyecto_profesor_sustenta;
import proyecto_final.backend.Services.Proyecto_profesor_sustentaDb;

@RestController
public class Proyecto_profesor_sustentaController{
    
    @GetMapping("/sustentaciones/all")
    List<Proyecto_profesor_sustenta> TodasLasSustentaciones(){
        return new Proyecto_profesor_sustentaDb().ObtenerTodasLasSustentaciones();
    }

    @PostMapping("/sustentaciones")
    public int InsertarSustentaciones(@RequestBody Proyecto_profesor_sustenta sustentaciones) {
        return new Proyecto_profesor_sustentaDb().GuardarSustentacion(sustentaciones);
    }

    @PutMapping("/sustentaciones")
    public int ActualizarSustentaciones(@RequestBody Proyecto_profesor_sustenta sustentaciones) {
        return new Proyecto_profesor_sustentaDb().ActualizarSustentacion(sustentaciones);
    }

    @DeleteMapping("/sustentaciones/{codigo}")
    public int Delete(@PathVariable("codigo") String codigo){
        return new Proyecto_profesor_sustentaDb().EliminarSustentacion(codigo);
    }
}