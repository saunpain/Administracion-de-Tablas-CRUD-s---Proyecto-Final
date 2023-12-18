package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Departamento;
import proyecto_final.backend.Services.DepartamentoDb;

@RestController
public class DepartamentoController {

    @GetMapping("/departamento/all")
    List<Departamento> TodosLosDepartamentos(){
        return new DepartamentoDb().ObtenerTodosLosDepartamentos();
    }

    @PostMapping("/departamento")
    public int InsertarDepartamento(@RequestBody Departamento departamento) {
        return new DepartamentoDb().GuardarDepartamento(departamento);
    }

    @PutMapping("/departamento")
    public int ActualizarDepartamento(@RequestBody Departamento departamento) {
        return new DepartamentoDb().ActualizarDepartamento(departamento);
    }

    @DeleteMapping("/departamento/{codigo}")
    public int Delete(@PathVariable("codigo") String codigo){
        return new DepartamentoDb().EliminarDepartamento(codigo);
    }
}
