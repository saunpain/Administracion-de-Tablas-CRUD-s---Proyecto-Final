package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Departamento;

public class DepartamentoDb {
    
    private Connection cn;

    public DepartamentoDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Departamento> ObtenerTodosLosDepartamentos(){
        List<Departamento> departamentos = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Departamento";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Departamento departamento = new Departamento(
                    rs.getString("cod_depto"),
                    rs.getString("nombre_departamento"),
                    rs.getInt("cod_profesor")
                );

                departamentos.add(departamento);
            }

            stmt.close();
            rs.close();
        } catch(Exception e){

        }
        return departamentos;
    }

        public int GuardarDepartamento(Departamento departamento){
        int resultado = 0;
        try{
            System.out.println(departamento.getCod_depto());
            System.out.println(departamento.getNombre_departamento());
            System.out.println(departamento.getCod_profesor());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirDepartamento " +
            "'" + departamento.getCod_depto() + "', " +
            "'" + departamento.getNombre_departamento() + "', " +
            departamento.getCod_profesor() + " ";

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarDepartamento(Departamento departamento){
        int resultado = 0;
        try{
            System.out.println(departamento.getCod_depto());
            System.out.println(departamento.getCod_deptoNuevo());
            System.out.println(departamento.getNombre_departamento());
            System.out.println(departamento.getCod_profesor());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarEstudiante " +
            "'" + departamento.getCod_depto() + "', " +
            "'" + departamento.getCod_deptoNuevo() + "', " +
            "'" + departamento.getNombre_departamento() + "', " +
            departamento.getCod_profesor() + " ";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarDepartamento(String codigo){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarDepartamento '" + codigo + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}
