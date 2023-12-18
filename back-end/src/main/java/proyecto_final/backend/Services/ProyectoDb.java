package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Proyecto;

public class ProyectoDb {
    
    private Connection cn;

    public ProyectoDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Proyecto> ObtenerTodosLosProyectos(){
        List<Proyecto> proyectos = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Proyecto";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Proyecto proyecto = new Proyecto(
                    rs.getString("cod_proyecto"),
                    rs.getString("tipo_proyecto"),
                    rs.getString("titulo_proyecto"),
                    rs.getInt("cod_profesor"),
                    rs.getString("fecha_entrega"),
                    rs.getString("fecha_verificacion"),
                    rs.getString("fecha_evaluacion"),
                    rs.getString("fecha_aprobacion"),
                    rs.getString("fecha_sustentacion")
                );

                proyectos.add(proyecto);
            }

            stmt.close();
            rs.close();
        } catch (Exception e){

        }
        return proyectos;
    }

    public List<Proyecto> FiltrarProyectos(String titulo, String tipo_proyecto, String etapa, int anio){
        List<Proyecto> proyectos = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "exec FiltrarProyecto '" + titulo + "', '" + tipo_proyecto + "', '" + etapa + "', " + anio;
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Proyecto proyecto = new Proyecto(
                    rs.getString("cod_proyecto"),
                    rs.getString("tipo_proyecto"),
                    rs.getString("titulo_proyecto"),
                    rs.getInt("cod_profesor"),
                    rs.getString("fecha_entrega"),
                    rs.getString("fecha_verificacion"),
                    rs.getString("fecha_evaluacion"),
                    rs.getString("fecha_aprobacion"),
                    rs.getString("fecha_sustentacion")
                );
                
                proyectos.add(proyecto);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return proyectos;
    }

    public int GuardarProyecto (Proyecto proyecto){
        int resultado = 0;
        try{
            System.out.println(proyecto.getCod_proyecto());
            System.out.println(proyecto.getTipo_proyecto());
            System.out.println(proyecto.getTitulo_proyecto());
            System.out.println(proyecto.getCod_profesor());
            System.out.println(proyecto.getFecha_entrega());
            System.out.println(proyecto.getFecha_verificacion());
            System.out.println(proyecto.getFecha_evaluacion());
            System.out.println(proyecto.getFecha_aprobacion());
            System.out.println(proyecto.getFecha_sustentacion());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirProyecto " +
            "'" + proyecto.getCod_proyecto() + "', " +
            "'" + proyecto.getTipo_proyecto() + "', " +
            "'" + proyecto.getTitulo_proyecto() + "', " +
            proyecto.getCod_profesor() + ", " +
            "'" + proyecto.getFecha_entrega() + "', " +
            "'" + proyecto.getFecha_verificacion() + "', " +
            "'" + proyecto.getFecha_evaluacion() + "', " +
            "'" + proyecto.getFecha_aprobacion() + "', " +
            "'" + proyecto.getFecha_sustentacion() + "'";
            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarProyecto(Proyecto proyecto){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec ActualizarProyecto " +
            "'" + proyecto.getCod_proyecto() + "', " +
            "'" + proyecto.getCodigoNuevo() + "', " +
            "'" + proyecto.getTipo_proyecto() + "', " +
            "'" + proyecto.getTitulo_proyecto() + "', " +
            proyecto.getCod_profesor() + ", ";
            
            if (proyecto.getFecha_entrega() != null) {
                query += "'" + proyecto.getFecha_entrega() + "', ";
            } else {
                query += "null, ";
            }
    
            if (proyecto.getFecha_verificacion() != null) {
                query += "'" + proyecto.getFecha_verificacion() + "', ";
            } else {
                query += "null, ";
            }
    
            if (proyecto.getFecha_evaluacion() != null) {
                query += "'" + proyecto.getFecha_evaluacion() + "', ";
            } else {
                query += "null, ";
            }
    
            if (proyecto.getFecha_aprobacion() != null) {
                query += "'" + proyecto.getFecha_aprobacion() + "', ";
            } else {
                query += "null, ";
            }
    
            if (proyecto.getFecha_sustentacion() != null) {
                query += "'" + proyecto.getFecha_sustentacion() + "'";
            } else {
                query += "null";
            }
            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarProyecto(String cod_proyecto){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarProyecto '" + cod_proyecto + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}