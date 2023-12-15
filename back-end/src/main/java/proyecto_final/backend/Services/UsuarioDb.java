package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Usuario;

public class UsuarioDb {
    
    private Connection  cn;

    public UsuarioDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Usuario> ObtenerTodosLosUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Usuario";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Usuario usuario = new Usuario(
                    rs.getInt("cod_usuario"),
                    rs.getString("usuario"),
                    rs.getString("contrasena"),
                    rs.getString("creado"),
                    rs.getInt("cod_tipo")
                );

                usuarios.add(usuario);
            }

            stmt.close();
            rs.close();
        } catch(Exception e){

        }
        return usuarios;
    }
}
