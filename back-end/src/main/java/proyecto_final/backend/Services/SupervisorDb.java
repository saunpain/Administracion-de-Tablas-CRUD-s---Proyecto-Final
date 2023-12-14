package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Supervisor;

public class SupervisorDb {
    
    private Connection cn;
    
    public SupervisorDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Supervisor> ObtenerTodosLosSupervisores(){
        List<Supervisor> supervisores = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Supervisor";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Supervisor supervisor = new Supervisor(
                    rs.getInt("cod_supervisor"),
                    rs.getString("nombre_supervisor"),
                    rs.getString("apellido_supervisor"),
                    rs.getString("cod_empresa")
                );

                supervisores.add(supervisor);
            }

            stmt.close();
            rs.close();
        } catch(Exception e){

        }
        return supervisores;
    }

    public int EliminarSupervisor(String csuperv){ //csuperv = Codigo Supervisor
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "delete from Supervisor where cod_supervisor = '" + csuperv + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}
