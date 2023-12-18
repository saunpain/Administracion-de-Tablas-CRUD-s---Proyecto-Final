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
                    rs.getInt("cod_tipo"),
                    rs.getString("Cedula_profesor"),
                    rs.getString("Cedula_administrativo"),
                    rs.getString("Cedula_estudiante")
                );

                usuarios.add(usuario);
            }

            stmt.close();
            rs.close();
        } catch(Exception e){

        }
        return usuarios;
    }
    public int GuardarUsuario(Usuario usuario){
        int resultado = 0;
        try{
            System.out.println(usuario.getCod_usuario());
            System.out.println(usuario.getUsuario());
            System.out.println(usuario.getCreado());
            System.out.println(usuario.getCedula_administrativo());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirUsuario " +
            "'" + usuario.getUsuario() + "', " +
            "'" + usuario.getCedula_administrativo() + "'";

            System.out.println(query);

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarUsuario(Usuario usuario){
        int resultado = 0;
        try{
            System.out.println(usuario.getUsuario());
            System.out.println(usuario.getCreado());
            System.out.println(usuario.getCedula_estudiante());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarUsuario " +
            "'" + usuario.getUsuario() + "', " +
            "'" + usuario.getCedula_estudiante() + "', ";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }
    public int EliminarUsuario(String usuario){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarUsuario '" + usuario + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }



    public List<Usuario> FiltrarUsuario( String cod_usuario, String Nomusuario){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "exec FiltrarUsuario " + cod_usuario + ", " + Nomusuario ;
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Usuario usuario = new Usuario(
                        rs.getInt("cod_usuario"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("creado"),
                        rs.getInt("cod_tipo"),
                        rs.getString("Cedula_profesor"),
                        rs.getString("Cedula_administrativo"),
                        rs.getString("Cedula_estudiante")
                    );

                    usuarios.add(usuario);
                }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return usuarios;
    }

    
}
