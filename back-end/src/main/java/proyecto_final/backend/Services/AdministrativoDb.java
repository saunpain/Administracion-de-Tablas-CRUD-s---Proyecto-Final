package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Administrativo;

public class AdministrativoDb {
    
    private Connection cn;

    public AdministrativoDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Administrativo> ObtenerTodosLosAdministrativos(){
        List<Administrativo> administrativos = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Administrativo";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Administrativo administrativo = new Administrativo(
                    rs.getInt("cod_admin"),
                    rs.getString("nombre_admin"),
                    rs.getString("apellido_admin"),
                    rs.getString("telefono_admin"),
                    rs.getString("correo_admin"),
                    rs.getString("Cedula_administrativo")
                );

                administrativos.add(administrativo);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {

        }
        return administrativos;
    }
}
