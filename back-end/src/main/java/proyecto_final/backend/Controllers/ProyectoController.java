package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import proyecto_final.backend.Models.Proyecto;
import proyecto_final.backend.Services.ProyectoDb;

@RestController
public class ProyectoController {
    
    @GetMapping("/proyecto/all")
    List<Proyecto> TodosLosProyectos(){
        return new ProyectoDb().ObtenerTodosLosProyectos();
    }

    @GetMapping("/proyecto/filtrar")
    public List<Proyecto> FiltrarProyectos(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String tipo_proyecto,
            @RequestParam(required = false) String etapa,
            @RequestParam(required = false) int anio) {
        return new ProyectoDb().FiltrarProyectos(titulo, tipo_proyecto, etapa, anio);
    }

    @PostMapping("/proyecto")
    public int InsertarProyecto(@RequestBody Proyecto proyecto) {
        return new ProyectoDb().GuardarProyecto(proyecto);
    }

    @PutMapping("/proyecto")
    public int ActualizarProyecto(@RequestBody Proyecto proyecto) {
        return new ProyectoDb().ActualizarProyecto(proyecto);
    }

    @DeleteMapping("/proyecto/{codigoProyecto}")
    public int Delete(@PathVariable("codigoProyecto") String cp){
        return new ProyectoDb().EliminarProyecto(cp);
    }
    
}
