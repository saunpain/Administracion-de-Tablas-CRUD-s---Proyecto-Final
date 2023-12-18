package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Sede;

public class SedeDb{
    private Connection cn;

    public SedeDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Sede> ObtenerTodasLasSedes(){
        List<Sede> sedes = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Sede";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Sede sede = new Sede(
                    rs.getString("cod_sede"),
                    rs.getString("nombre_sede"),
                    rs.getString("ubicacion")
                );

                sedes.add(sede);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return sedes;
    }

    public int EliminarSede(String cs){ //cs = Codigo Sede
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarSede '" + cs + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
        }

        public int GuardarSede(Sede sede){
        int resultado = 0;
        try{
            System.out.println(sede.getCod_sede());
            System.out.println(sede.getNombre_sede());
            System.out.println(sede.getUbicacion());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirSede '" +
            sede.getCod_sede() + "', " +
            "'" + sede.getNombre_sede() + "', " +
            "'" + sede.getUbicacion() + "', ";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }
    

    public int ActualizarSede(Sede sede){
        int resultado = 0;
        try{
            System.out.println(sede.getCod_sede());
            System.out.println(sede.getCod_sedeNuevo());
            System.out.println(sede.getNombre_sede());
            System.out.println(sede.getUbicacion());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarSede '" +
            sede.getCod_sede() + "', " +
            "'" + sede.getCod_sedeNuevo() + "', " +
            "'" + sede.getNombre_sede() + "', " +
            "'" + sede.getUbicacion() + "', ";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }
}