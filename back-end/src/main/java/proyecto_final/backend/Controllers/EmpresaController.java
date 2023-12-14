package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Empresa;
import proyecto_final.backend.Services.EmpresaDb;

@RestController
public class EmpresaController {
    
    @GetMapping("/empresa/all")
    List<Empresa> TodasLasEmpresas(){
        return new EmpresaDb().ObtenerTodasLasEmpresas();
    }

    @DeleteMapping("/empresa/{codigoEmpresa}")
    public int Delete(@PathVariable("codigoEmpresa") String ce){
        return new EmpresaDb().EliminarEmpresa(ce);
    }
}
