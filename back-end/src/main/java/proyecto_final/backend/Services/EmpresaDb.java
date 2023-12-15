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

    public int GuardarEmpresa(Empresa empresa) {
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = " "; //proceso almacenado para guardar empresas

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int ActualizarEmpresa(Empresa empresa) {
        int resultado = 0;

        try{
            Statement stmt = cn.createStatement();
            String query = " ";

            resultado = stmt.executeUpdate(query);

            stmt.close();
            return resultado;
        } catch (Exception e) {

        }
        return resultado;
    }

    public int EliminarEmpresa(String ce){ //ce = Codigo Empresa
        int resultado = 0;
        try{
            Statement stmt = cn.createStatement();
            String query = "delete from Empresa where cod_empresa = '" + ce + "'";

            return stmt.executeUpdate(query);
        } catch (Exception e) {

        }
        return resultado;
    }
}
