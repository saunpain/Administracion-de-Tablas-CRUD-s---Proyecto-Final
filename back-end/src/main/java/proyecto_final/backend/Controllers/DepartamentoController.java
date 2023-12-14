package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Departamento;
import proyecto_final.backend.Services.DepartamentoDb;

@RestController
public class DepartamentoController {

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/departamento/all")
    List<Departamento> TodosLosDepartamentos(){
        return new DepartamentoDb().ObtenerTodosLosDepartamentos();
    }
}
