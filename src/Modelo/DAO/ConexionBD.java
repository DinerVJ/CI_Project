package Modelo.DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD implements IntConexionBDDAO{
    
    private static Connection cn = null;
    
    public static Connection conectar(){
        
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
        return cn;
        
//        try {
//            Class.forName(driver);
//            cn = DriverManager.getConnection(url, user, password);
//            System.out.println("Exito");
//        } catch (SQLException e) {
//            System.out.println("Error de conexion: " + e.getMessage());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cn;
    }
}
