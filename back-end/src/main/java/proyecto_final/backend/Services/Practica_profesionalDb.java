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
    
}
