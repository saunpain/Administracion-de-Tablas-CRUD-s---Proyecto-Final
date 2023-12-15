package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Empresa;
import proyecto_final.backend.Services.EmpresaDb;

@RestController
public class EmpresaController {
    
    @GetMapping("/empresa/all")
    List<Empresa> TodasLasEmpresas(){
        return new EmpresaDb().ObtenerTodasLasEmpresas();
    }

    @PostMapping("/empresa")
    public int InsertarEmpresa(@RequestBody Empresa empresa){
        return new EmpresaDb().GuardarEmpresa(empresa);
    }

    @PutMapping("/empresa")
    public int ActualizarEmpresa(@RequestBody Empresa empresa) {
        return new EmpresaDb().ActualizarEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{codigoEmpresa}")
    public int Delete(@PathVariable("codigoEmpresa") String ce){
        return new EmpresaDb().EliminarEmpresa(ce);
    }
}
