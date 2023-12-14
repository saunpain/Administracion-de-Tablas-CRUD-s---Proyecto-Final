package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Proyecto;

public class ProyectoDb {
    
    private Connection cn;

    public ProyectoDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Proyecto> ObtenerTodosLosProyectos(){
        List<Proyecto> proyectos = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Proyecto";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Proyecto proyecto = new Proyecto(
                    rs.getString("cod_proyecto"),
                    rs.getString("tipo_proyecto"),
                    rs.getString("titulo_proyecto"),
                    rs.getInt("cod_profesor"),
                    rs.getString("fecha_entrega"),
                    rs.getString("fecha_verificacion"),
                    rs.getString("fecha_evaluacion"),
                    rs.getString("fecha_aprobacion"),
                    rs.getString("fecha_sustentacion")
                );

                proyectos.add(proyecto);
            }

            stmt.close();
            rs.close();
        } catch (Exception e){

        }
        return proyectos;
    }
}
