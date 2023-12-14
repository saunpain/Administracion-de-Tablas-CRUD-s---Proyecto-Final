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
}
