package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Tipo_usuario;
import proyecto_final.backend.Services.Tipo_usuarioDb;

@RestController
public class Tipo_usuarioController {
    
    @GetMapping("/tipoUsuario/all")
    public List<Tipo_usuario> TodosLosTiposDeUsuario(){
        return new Tipo_usuarioDb().ObtenerTodosLosTiposDeUsuario();
    }
}
