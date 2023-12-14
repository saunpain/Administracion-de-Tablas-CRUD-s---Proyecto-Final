package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Telf_Estud;

public class Telf_EstudDb {
    private Connection cn;
    
    public Telf_EstudDb(){
        this.cn = new Conexion().openDb();
    }
    
    public List<Telf_Estud> ObtenerTodosLosTelefonos(){
        List<Telf_Estud> telefonos = new ArrayList<>();
        
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Telf_Estud";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Telf_Estud telefono = new Telf_Estud(
                    rs.getString("cedula"),
                    rs.getString("telefono")
                );

                telefonos.add(telefono);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {
            
        }
        
        return telefonos;
    }
}
