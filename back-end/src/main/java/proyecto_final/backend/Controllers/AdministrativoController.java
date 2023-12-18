package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import proyecto_final.backend.Models.Administrativo;
import proyecto_final.backend.Services.AdministrativoDb;

@RestController
public class AdministrativoController {
    
    @GetMapping("/administrativo/all")
    public List<Administrativo> TodosLosAdministrativos(){
        return new AdministrativoDb().ObtenerTodosLosAdministrativos();
    }
    
    @PostMapping("/administrativo")
    public int InsertarAdministrativo(@RequestBody Administrativo admin) {
        return new AdministrativoDb().GuardarAdministrativo(admin);
    }

    @PutMapping("/administrativo")
    public int ActualizarAdministrativo(@RequestBody Administrativo admin) {
        return new AdministrativoDb().ActualizarAdministrativo(admin);
    }

    @DeleteMapping("/administrativo/{codigo}")
    public int Delete(@PathVariable("codigo") String codigo){
        return new AdministrativoDb().EliminarAdministrativo(codigo);
    }
}
