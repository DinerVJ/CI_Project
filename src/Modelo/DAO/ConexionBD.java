package Modelo.DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements IConexionBDDAO{
    
    private static Connection cn = null;
    
    public static Connection conectar(){
        
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
        return cn;
        
    }
}
