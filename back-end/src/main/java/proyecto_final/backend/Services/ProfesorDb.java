package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Profesor;


public class ProfesorDb{
    private Connection cn;

    public ProfesorDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Profesor> ObtenerTodasLosProfesores(){
        List<Profesor> profesores = new ArrayList<>();
        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Profesor";
            ResultSet rs = stmt.executeQuery(query);
            
            
            while(rs.next()){
                Profesor profesor = new Profesor(
                    rs.getInt("cod_profesor"),
                    rs.getString("nombre_prof"),
                    rs.getString("apellido_prof"),
                    rs.getString("tipo_prof"),
                    rs.getString("cod_depto")
                );
                profesores.add(profesor);
            }

            stmt.close();
            rs.close();

        }catch(Exception e){
            
        }

        return profesores;
    }
}