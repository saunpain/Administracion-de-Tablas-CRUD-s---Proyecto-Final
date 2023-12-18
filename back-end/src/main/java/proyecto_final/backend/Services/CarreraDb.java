package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Carrera;
import proyecto_final.backend.Models.Estudiante;

public class CarreraDb {
    
    private Connection cn;

    public CarreraDb() {
        this.cn = new Conexion().openDb();
    }

    public List<Carrera> ObtenerTodasLasCarreras(){
        List<Carrera> carreras = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Carrera";
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

public int GuardarCarrera(Carrera carrera){
        int resultado = 0;
        try{
            System.out.println(carrera.getCod_carrera());
            System.out.println(carrera.getNombre_carrera());
            System.out.println(carrera.getCod_depto());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirCarrera " +
            "'" + carrera.getCod_carrera() + "', " +
            "'" + carrera.getNombre_carrera() + "', " +
            "'" + carrera.getCod_depto() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarCarrera(Carrera carrera){
        int resultado = 0;
        try{
            System.out.println(carrera.getCod_carrera());
            System.out.println(carrera.getCod_carreraNuevo());
            System.out.println(carrera.getNombre_carrera());
            System.out.println(carrera.getCod_depto());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarCarrera " +
            "'" + carrera.getCod_carrera() + "', " +
            "'" + carrera.getCod_carreraNuevo() + "', " +
            "'" + carrera.getNombre_carrera() + "', " +
            "'" + carrera.getCod_depto() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarCarrera(String codigo){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarCarrera '" + codigo + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }



    
}
