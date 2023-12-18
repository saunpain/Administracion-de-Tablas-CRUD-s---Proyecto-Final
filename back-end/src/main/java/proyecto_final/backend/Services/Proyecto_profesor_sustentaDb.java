package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Proyecto_profesor_sustenta;

public class Proyecto_profesor_sustentaDb{
    private Connection cn;

    public Proyecto_profesor_sustentaDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Proyecto_profesor_sustenta> ObtenerTodasLasSustentaciones(){
        List<Proyecto_profesor_sustenta> sustentaciones = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Proyecto_profesor_sustenta";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Proyecto_profesor_sustenta sustentacion = new Proyecto_profesor_sustenta(
                    rs.getInt("cod_profesor"),
                    rs.getString("cod_proyecto"),
                    rs.getString("lugar"),
                    rs.getString("nota_asignada")
                );

                sustentaciones.add(sustentacion);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return sustentaciones;
    }


    public int GuardarSustentacion(Proyecto_profesor_sustenta sustentaciones){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec AñadirSustentacion " 
            + sustentaciones.getCod_profesor() + ", " 
            + "'" + sustentaciones.getCod_proyecto() + "', " 
            + "'" + sustentaciones.getLugar() + "', "
            + "'" + sustentaciones.getNota_asignada() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarSustentacion(Proyecto_profesor_sustenta Sustentacion){
        int resultado = 0;
        try{
            System.out.println(Sustentacion.getCod_profesor());
            System.out.println(Sustentacion.getCod_profesorNuevo());
            System.out.println(Sustentacion.getCod_proyecto());
            System.out.println(Sustentacion.getLugar());
            System.out.println(Sustentacion.getNota_asignada());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarSustentaciones " +
            + Sustentacion.getCod_profesor() + ", " 
            + Sustentacion.getCod_profesorNuevo() + ", " 
            + "'" + Sustentacion.getCod_proyecto() + "', " 
            + "'" + Sustentacion.getLugar() + "', " 
            + "'" + Sustentacion.getNota_asignada() + "', ";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarSustentacion(String codigo){ 
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarSustentacion " + codigo;

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}