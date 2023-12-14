package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Empresa;
import proyecto_final.backend.Services.EmpresaDb;

@RestController
public class EmpresaController {
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/empresa/all")
    List<Empresa> TodasLasEmpresas(){
        return new EmpresaDb().ObtenerTodasLasEmpresas();
    }
}
