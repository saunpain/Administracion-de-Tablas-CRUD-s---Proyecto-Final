package proyecto_final.backend.Controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Profesor;
import proyecto_final.backend.Services.ProfesorDb;

@RestController
public class ProfesorController {
    
    @GetMapping("/profesor/all")
    List<Profesor> TodasLosProfesores(){
        return new ProfesorDb().ObtenerTodosLosProfesores();
    }

    @GetMapping("/profesor/filtrar")
    public List<Profesor> FiltrarProfesores(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String departamento,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String sede) {

            try {
                tipo = URLDecoder.decode(tipo, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                
            }
        return new ProfesorDb().FiltrarProfesores(nombre, departamento, tipo, sede);
    }

    @PostMapping("/profesor")
    public int InsertarProfesor(@RequestBody Profesor profesor) {
        return new ProfesorDb().GuardarProfesor(profesor);
    }

    @PutMapping("/profesor")
    public int ActualizarProfesor(@RequestBody Profesor profesor) {
        return new ProfesorDb().ActualizarProfesor(profesor);
    }

    @DeleteMapping("/profesor/{codigoProfesor}")
    public int Delete(@PathVariable("codigoProfesor") String cprof){
        return new ProfesorDb().EliminarProfesor(cprof);
    }
}