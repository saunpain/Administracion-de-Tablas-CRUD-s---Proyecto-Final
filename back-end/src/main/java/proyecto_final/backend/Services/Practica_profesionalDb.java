package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Practica_profesional;

public class Practica_profesionalDb {
    
    private Connection cn;

    public Practica_profesionalDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Practica_profesional> ObtenerTodasLasPracticas(){
        List<Practica_profesional> practicas = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Practica_profesional";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Practica_profesional practica = new Practica_profesional(
                    rs.getString("cod_proyecto"),
                    rs.getInt("cod_supervisor")
                );

                practicas.add(practica);
            }

            stmt.close();
            rs.close();

        } catch(Exception e){
            
        }
                return practicas;
    }


    
    public int GuardarPractica(Practica_profesional practica){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec AñadirPractica '" +
            practica.getCod_proyecto() + "', " +
            "'" + practica.getCod_proyecto() + "', ";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }
    
    
    public int EliminarPractica(String Practica){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarPractica'" + Practica + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }

    public int ActualizarPractica(Practica_profesional practica){
        int resultado = 0;
        try{
            System.out.println(practica.getCod_proyecto());
            System.out.println(practica.getCod_proyecto());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarPractica'" +
            practica.getCod_proyecto() + "', " +
            "'" + practica.getCod_proyecto()+ "', ";


            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {
        }
        return resultado;
    }
}
