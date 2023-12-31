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
            String query = "SELECT * FROM VistaEstudiante";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Estudiante estudiante = new Estudiante(
                    rs.getString("cedula"),
                    rs.getString("pri_nom"),
                    rs.getString("seg_nom"),
                    rs.getString("pri_apellido"),
                    rs.getString("seg_apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("cod_proyecto"),
                    rs.getString("cod_carrera"),
                    rs.getInt("año_cursa"),
                    rs.getFloat("indice"),
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

    public List<Estudiante> FiltrarEstudiantes(String nombre, String identificacion, String carrera, String anio){
        List<Estudiante> estudiantes = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "exec FiltrarEstudiantes " + nombre + ", " + carrera + ", " + identificacion + ", " + anio;
            String queryNoNull = "exec FiltrarEstudiantes " + nombre + ", " + carrera + ", " + identificacion + ", " + anio;
            ResultSet rs = stmt.executeQuery(query);

            System.out.println(query);
            
            while(rs.next()){
                Estudiante estudiante = new Estudiante(
                    rs.getString("cedula"),
                    rs.getString("pri_nom"),
                    rs.getString("seg_nom"),
                    rs.getString("pri_apellido"),
                    rs.getString("seg_apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("cod_proyecto"),
                    rs.getString("cod_carrera"),
                    rs.getInt("año_cursa"),
                    rs.getFloat("indice"),
                    rs.getString("cod_sede")
                );
                
                estudiantes.add(estudiante);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return estudiantes;
    }

    public int GuardarEstudiante(Estudiante estudiante){
        int resultado = 0;
        try{
            System.out.println(estudiante.getCedula());
            System.out.println(estudiante.getPri_nom());
            System.out.println(estudiante.getSeg_nom());
            System.out.println(estudiante.getPri_apellido());
            System.out.println(estudiante.getSeg_apellido());
            System.out.println(estudiante.getAnio_cursa());
            System.out.println(estudiante.getSemestre());
            System.out.println(estudiante.getIndice());
            System.out.println(estudiante.getCod_proyecto());
            System.out.println(estudiante.getCod_carrera());
            System.out.println(estudiante.getCod_sede());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirEstudiante " +
            "'" + estudiante.getCedula() + "', " +
            "'" + estudiante.getPri_nom() + "', " +
            "'" + estudiante.getSeg_nom() + "', " +
            "'" + estudiante.getPri_apellido() + "', " +
            "'" + estudiante.getSeg_apellido() + "', " +
            estudiante.getAnio_cursa() + ", " +
            estudiante.getIndice() + ", " +
            "'" + estudiante.getCod_proyecto() + "', " +
            "'" + estudiante.getCod_carrera() + "', " +
            "'" + estudiante.getCod_sede() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarEstudiante(Estudiante estudiante){
        int resultado = 0;
        try{
            System.out.println(estudiante.getCedula());
            System.out.println(estudiante.getCedulaNueva());
            System.out.println(estudiante.getPri_nom());
            System.out.println(estudiante.getSeg_nom());
            System.out.println(estudiante.getPri_apellido());
            System.out.println(estudiante.getSeg_apellido());
            System.out.println(estudiante.getTelefono());
            System.out.println(estudiante.getCorreo());
            System.out.println(estudiante.getAnio_cursa());
            System.out.println(estudiante.getIndice());
            System.out.println(estudiante.getCod_proyecto());
            System.out.println(estudiante.getCod_carrera());
            System.out.println(estudiante.getCod_sede());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarEstudiante " +
            "'" + estudiante.getCedula() + "', " +
            "'" + estudiante.getCedulaNueva() + "', " +
            "'" + estudiante.getPri_nom() + "', " +
            "'" + estudiante.getSeg_nom() + "', " +
            "'" + estudiante.getPri_apellido() + "', " +
            "'" + estudiante.getSeg_apellido() + "', " +
            "'" + estudiante.getTelefono() + "', " +
            "'" + estudiante.getCorreo() + "', " +
            "'" + estudiante.getCod_proyecto() + "', " +
            "'" + estudiante.getCod_carrera() + "', " +
            estudiante.getAnio_cursa() + ", " +
            estudiante.getIndice() + ", " +
            "'" + estudiante.getCod_sede() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarEstudiante(String cedula){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarEstudiante '" + cedula + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}
