package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Evaluacion;

public class EvaluacionDb{
    private Connection cn;

    public EvaluacionDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Evaluacion> ObtenerTodasLasEvaluaciones(){
        List<Evaluacion> evaluaciones = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Evaluacion";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Evaluacion evaluacion = new Evaluacion(
                    rs.getString("fecha_evaluacion"),
                    rs.getString("cod_proyecto"),
                    rs.getString("evaluacion")
                );

                evaluaciones.add(evaluacion);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return evaluaciones;
    }

    public int GuardarEvaluacion(Evaluacion evaluacion){
        int resultado = 0;
        try{
            System.out.println(evaluacion.getFecha_evaluacion());
            System.out.println(evaluacion.getCod_proyecto());
            System.out.println(evaluacion.getEvaluacion());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirEvaluacion " +
            "'" + evaluacion.getFecha_evaluacion() + "', " +
            "'" + evaluacion.getCod_proyecto() + "', " +
            "'" + evaluacion.getEvaluacion() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarEvaluacion(Evaluacion evaluacion){
        int resultado = 0;
        try{
            System.out.println(evaluacion.getFecha_evaluacion());
            System.out.println(evaluacion.getFecha_evaluacionNueva());
            System.out.println(evaluacion.getCod_proyecto());
            System.out.println(evaluacion.getEvaluacion());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarEvaluacion " +
            "'" + evaluacion.getFecha_evaluacion() + "', " +
            "'" + evaluacion.getFecha_evaluacionNueva() + "', " +
            "'" + evaluacion.getCod_proyecto() + "', " +
            "'" + evaluacion.getEvaluacion() + "'";
            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarEvaluacion(String fecha){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarEvaluacion '" + fecha + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}