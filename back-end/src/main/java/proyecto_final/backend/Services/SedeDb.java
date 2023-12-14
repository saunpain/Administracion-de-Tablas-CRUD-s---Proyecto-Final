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
}