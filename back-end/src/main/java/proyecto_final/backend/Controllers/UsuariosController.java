package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Usuario;
import proyecto_final.backend.Services.UsuarioDb;

@RestController
public class UsuariosController {
    
    @GetMapping("/usuario/all")
    public List<Usuario> TodoslosUsuarios(){
        return new UsuarioDb().ObtenerTodosLosUsuarios();
    }

    @PostMapping("/usuario")
    public int InsertarUsuario(@RequestBody Usuario usuario) {
        return new UsuarioDb().GuardarUsuario(usuario);
    }

    @PutMapping("/usuario")
    public int ActualizarAdministrativo(@RequestBody Usuario usuario) {
        return new UsuarioDb().ActualizarUsuario(usuario);
    }

    @DeleteMapping("/usuario/{codigo}")
    public int Delete(@PathVariable("codigo") String codigo){
        return new UsuarioDb().EliminarUsuario(codigo);
    }
    
}
