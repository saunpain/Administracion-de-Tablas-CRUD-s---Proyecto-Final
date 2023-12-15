package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Profesor;


public class ProfesorDb{
    private Connection cn;

    public ProfesorDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Profesor> ObtenerTodosLosProfesores(){
        List<Profesor> profesores = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Profesor";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Profesor profesor = new Profesor(
                    rs.getInt("cod_profesor"),
                    rs.getString("nombre_prof"),
                    rs.getString("apellido_prof"),
                    rs.getString("tipo_prof"),
                    rs.getString("cod_depto")
                );
                profesores.add(profesor);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return profesores;
    }

    public List<Profesor> FiltrarProfesores(String nombre, String departamento, String tipo, String sede){
        List<Profesor> profesores = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = " "; //Query para filtro con metodo WHERE
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Profesor profesor = new Profesor(
                    rs.getInt("cod_profesor"),
                    rs.getString("nombre_prof"),
                    rs.getString("apellido_prof"),
                    rs.getString("tipo_prof"),
                    rs.getString("cod_depto")
                );
                profesores.add(profesor);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return profesores;
    }

    public int EliminarProfesor(String cprof){ //cprof = Codigo Profesor
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "delete from Profesor where cod_profesor = '" + cprof + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}