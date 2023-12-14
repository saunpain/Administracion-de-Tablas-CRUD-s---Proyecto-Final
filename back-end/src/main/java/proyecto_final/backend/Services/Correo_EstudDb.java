package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Correo_Estud;

public class Correo_EstudDb {
    
    private Connection cn;

    public Correo_EstudDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Correo_Estud> ObtenerTodosLosCorreos(){
        List<Correo_Estud> correos = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Correo_Estud";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Correo_Estud correo = new Correo_Estud(
                    rs.getString("cedula"),
                    rs.getString("correo")
                );

                correos.add(correo);
            }

            stmt.close();
            rs.close();
        } catch(Exception e){

        }

        return correos;
    }
}
