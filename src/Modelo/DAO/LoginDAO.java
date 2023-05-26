package Modelo.DAO;

import Vista.VistaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    Connection cn = null;
    private String User = null;
    
    public void iniciarSesion() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "SELECT username, password, profile FROM usuario WHERE active=1 AND username='" + User + "'";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String u = rs.getString("username");
                String pass = rs.getString("password");
                String priv = rs.getString("profile");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
