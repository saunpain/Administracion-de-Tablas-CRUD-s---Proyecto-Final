package proyecto_final.backend.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.backend.Helpers.Conexion;
import proyecto_final.backend.Models.Empresa;

public class EmpresaDb {
    
    private Connection cn;

    public EmpresaDb(){
        this.cn = new Conexion().openDb();
    }

    public List<Empresa> ObtenerTodasLasEmpresas(){
        List<Empresa> empresas = new ArrayList<>();

        try{
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Empresa";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Empresa empresa = new Empresa(
                    rs.getString("cod_empresa"),
                    rs.getString("nombre_empresa")
                );

                empresas.add(empresa);
            }

            stmt.close();
            rs.close();
        } catch (Exception e){

        }
        return empresas;
    }

public int GuardarEmpresa(Empresa empresas){
        int resultado = 0;
        try{
            System.out.println(empresas.getCod_empresa());
            System.out.println(empresas.getNombre_empresa());

            Statement stmt = cn.createStatement();
            String query = "exec AñadirEmpresa" +
            "'" + empresas.getCod_empresa() + "', " +
            "'" + empresas.getNombre_empresa();

            System.out.println(query);

            resultado = stmt.executeUpdate(query);

            stmt.close();

            return resultado;
        } catch (Exception e){
            
        }
        return resultado;
    }

    public int ActualizarEmpresa(Empresa empresa){
        int resultado = 0;
        try{
            System.out.println(empresa.getCod_empresa());
            System.out.println(empresa.getNombre_empresa());

            Statement stmt = cn.createStatement();
            String query = "exec ActualizarEmpresa " +
            "'" + empresa.getCod_empresa() + "', " +
            "'" + empresa.getNombre_empresa() + "'";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

        public int EliminarEmpresa(String cod_empresa){
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "exec EliminarEmpresa '" + cod_empresa + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}


