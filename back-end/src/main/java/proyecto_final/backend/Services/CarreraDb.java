package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Carrera;

public class CarreraDb {
    
    private Connection cn;

    public CarreraDb() {
        this.cn = new Conexion().openDb();
    }

    public List<Carrera> ObtenerTodasLasCarreras(){
        List<Carrera> carreras = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Carreras";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Carrera carrera = new Carrera(
                    rs.getString("cod_carrera"),
                    rs.getString("nombre_carrera"),
                    rs.getString("cod_depto")
                );

                carreras.add(carrera);
            }

            stmt.close();
            rs.close();
        } catch(Exception e){

        }
        return carreras;
    }
}
