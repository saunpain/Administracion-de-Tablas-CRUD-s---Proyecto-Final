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
}