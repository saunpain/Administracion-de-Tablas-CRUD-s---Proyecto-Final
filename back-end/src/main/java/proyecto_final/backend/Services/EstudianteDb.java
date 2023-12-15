package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Estudiante;

public class EstudianteDb {
    
    private Connection cn;

    public EstudianteDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Estudiante> ObtenerTodosLosEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Estudiante";
            ResultSet rs = stmt.executeQuery(query);
 
            while(rs.next()){
                Estudiante estudiante = new Estudiante(
                    rs.getString("cedula"),
                    rs.getString("pri_nom"),
                    rs.getString("seg_nom"),
                    rs.getString("pri_apellido"),
                    rs.getString("seg_apellido"),
                    rs.getInt("año_cursa"),
                    rs.getString("semestre"),
                    rs.getFloat("indice"),
                    rs.getString("cod_proyecto"),
                    rs.getString("cod_carrera"),
                    rs.getString("cod_sede")
                );

                estudiantes.add(estudiante);
            }

            rs.close();
            stmt.close();
        } catch(Exception e){

        }
        return estudiantes;
    }

    public List<Estudiante> FiltrarEstudiantes(String nombre, String carrera, String identificacion, String anio){
        List<Estudiante> estudiantes = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = " ";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Estudiante estudiante = new Estudiante(
                    rs.getString("cedula"),
                    rs.getString("pri_nom"),
                    rs.getString("seg_nom"),
                    rs.getString("pri_apellido"),
                    rs.getString("seg_apellido"),
                    rs.getInt("año_cursa"),
                    rs.getString("semestre"),
                    rs.getFloat("indice"),
                    rs.getString("cod_proyecto"),
                    rs.getString("cod_carrera"),
                    rs.getString("cod_sede")
                );

                estudiantes.add(estudiante);
            }
            stmt.close();
            rs.close();
        } catch (Exception e){

        }
        return estudiantes;
    }

    public int EliminarEstudiante(String cedula){ //cedula = Cedula Estudiante
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "delete from Estudiante where cedula = '" + cedula + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}
