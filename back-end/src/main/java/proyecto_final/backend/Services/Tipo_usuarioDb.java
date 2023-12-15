package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Tipo_usuario;

public class Tipo_usuarioDb {
    
    private Connection cn;

    public Tipo_usuarioDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Tipo_usuario> ObtenerTodosLosTiposDeUsuario(){
        List<Tipo_usuario> tiposUsuario = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Tipo_usuario";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Tipo_usuario tipoUsuario = new Tipo_usuario(
                    rs.getInt("cod_tipo"),
                    rs.getString("tipo")
                );

                tiposUsuario.add(tipoUsuario);
            }

            stmt.close();
            rs.close();
        } catch (Exception e){

        }
        return tiposUsuario;
    }
}
