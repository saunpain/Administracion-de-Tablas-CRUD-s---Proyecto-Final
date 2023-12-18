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
                    rs.getString("cod_depto"),
                    rs.getString("telefono_profesor"),
                    rs.getString("correo_profesor"),
                    rs.getString("Cedula_profesor")
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
            String query = "exec FiltrarProfesores " + nombre + ", " + departamento + ", " + tipo;
            String queryNoNull = "exec FiltrarProfesores " + nombre + ", " + departamento + ", " + "'" + tipo + "'";
            ResultSet rs;

            if("null".equals(tipo)){
                rs = stmt.executeQuery(query);
            }
            else{
                rs = stmt.executeQuery(queryNoNull);
            }
            
            while(rs.next()){
                Profesor profesor = new Profesor(
                    rs.getInt("cod_profesor"),
                    rs.getString("nombre_prof"),
                    rs.getString("apellido_prof"),
                    rs.getString("tipo_prof"),
                    rs.getString("cod_depto"),
                    rs.getString("telefono_profesor"),
                    rs.getString("correo_profesor"),
                    rs.getString("Cedula_profesor")
                );
                profesores.add(profesor);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return profesores;
    }

    public int GuardarProfesor(Profesor profesor){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec AñadirProfesor " 
            + profesor.getCod_profesor() + ", " 
            + "'" + profesor.getNombre_prof() + "', " 
            + "'" + profesor.getApellido_prof() + "', " 
            + "'" + profesor.getTipo_prof() + "', " 
            + "'" + profesor.getCod_depto() + "', " 
            + "'" + profesor.getTelefono_profesor() + "', " 
            + "'" + profesor.getCorreo_profesor() + "', " 
            + "'" + profesor.getCedula_profesor() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarProfesor(Profesor profesor){
        int resultado = 0;
        try{
            System.out.println(profesor.getCod_profesor());
            System.out.println(profesor.getCod_profesorNuevo());
            System.out.println(profesor.getNombre_prof());
            System.out.println(profesor.getApellido_prof());
            System.out.println(profesor.getTipo_prof());
            System.out.println(profesor.getCod_depto());
            System.out.println(profesor.getTelefono_profesor());
            System.out.println(profesor.getCorreo_profesor());
            System.out.println(profesor.getCedula_profesor());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarProfesor " +
            + profesor.getCod_profesor() + ", " 
            + profesor.getCod_profesorNuevo() + ", " 
            + "'" + profesor.getNombre_prof() + "', " 
            + "'" + profesor.getApellido_prof() + "', " 
            + "'" + profesor.getTipo_prof() + "', " 
            + "'" + profesor.getCod_depto() + "', " 
            + "'" + profesor.getTelefono_profesor() + "', " 
            + "'" + profesor.getCorreo_profesor() + "', " 
            + "'" + profesor.getCedula_profesor() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarProfesor(String cprof){ //cprof = Codigo Profesor
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarProfesor " + cprof;

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}