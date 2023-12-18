package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import proyecto_final.backend.Models.Sede;
import proyecto_final.backend.Services.SedeDb;

@RestController
public class SedeController{
    
    @GetMapping("/sede/all")
    List<Sede> TodasLasSedes(){
        return new SedeDb().ObtenerTodasLasSedes();
    }

    @PostMapping("/sede")
    public int InsertarSede(@RequestBody Sede sede) {
        return new SedeDb().GuardarSede(sede);
    }

    @PutMapping("/sede")
    public int ActualizarSede(@RequestBody Sede sede) {
        return new SedeDb().ActualizarSede(sede);
    }


    @DeleteMapping("/sede/{codigoSede}")
    public int Delete(@PathVariable("codigoSede") String cs){
        return new SedeDb().EliminarSede(cs);
    }
}