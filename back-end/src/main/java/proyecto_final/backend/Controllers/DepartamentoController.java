package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import proyecto_final.backend.Models.Departamento;
import proyecto_final.backend.Services.DepartamentoDb;

@RestController
public class DepartamentoController {

    @GetMapping("/departamento/all")
    List<Departamento> TodosLosDepartamentos(){
        return new DepartamentoDb().ObtenerTodosLosDepartamentos();
    }

    @DeleteMapping("/departamento/{codigoDepartamento}")
    public int Delete(@PathVariable("codigoDepartamento") String cd){
        return new DepartamentoDb().EliminarDepartamento(cd);
    }
}
