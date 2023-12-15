package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Usuario;
import proyecto_final.backend.Services.UsuarioDb;

@RestController
public class UsuariosController {
    
    @GetMapping("/usuario/all")
    public List<Usuario> TodoslosUsuarios(){
        return new UsuarioDb().ObtenerTodosLosUsuarios();
    }
}
