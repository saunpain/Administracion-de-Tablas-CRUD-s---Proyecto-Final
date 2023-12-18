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

            stmt.close();
            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }

        return resultado;
    }

    
    public int GuardarSupervisor(Supervisor supervisor){
        int resultado = 0;
        try{
            System.out.println(supervisor.getCod_supervisor());
            System.out.println(supervisor.getNombre_supervisor());
            System.out.println(supervisor.getApellido_supervisor());
            System.out.println(supervisor.getCod_empresa());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirSupervisor " +
            "'" + supervisor.getNombre_supervisor() + "', " +
            "'" + supervisor.getApellido_supervisor() + "', " +
            "'" + supervisor.getCod_empresa() + "'";

            System.out.println(query);

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarSupervisor(Supervisor supervisor){
        int resultado = 0;
        try{
            System.out.println(supervisor.getCod_supervisor());
            System.out.println(supervisor.getNombre_supervisor());
            System.out.println(supervisor.getApellido_supervisor());
            System.out.println(supervisor.getCod_empresa());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarEstudiante " +
            supervisor.getCod_supervisor() + ", " +
            "'" + supervisor.getNombre_supervisor() + "', " +
            "'" + supervisor.getApellido_supervisor() + "', " +
            "'" + supervisor.getCod_empresa() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }
}
