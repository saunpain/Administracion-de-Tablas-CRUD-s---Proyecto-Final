package proyecto_final.backend.Helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    public Connection openDb(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://;serverName=sql8006.site4now.net;databaseName=db_a937a5_121;encrypt=true;trustServerCertificate=true", "db_a937a5_121_admin", "Shuffuling2009*");
        } catch(SQLException e) {

        } catch (ClassNotFoundException cnfex){
            
        }
        return null;
    }
}
