
package Modelo.DAO;

import Modelo.DTO.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IntUsuarioDAO{

    private Connection cn;
    
    @Override
    public boolean crearUsuario(Usuario u) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "INSERT INTO usuario(username,password,profile,active)VALUES(?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getProfile());
            ps.setInt(4, u.getActive());
            ps.executeUpdate();
            cn.close();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR al guardar." + e.getMessage());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean leerUsuario(Usuario u) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "SELECT * FROM usuario WHERE idUser=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, u.getIdUser());
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setProfile(rs.getString("profile"));
                u.setActive(rs.getInt("active"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario u) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "UPDATE usuario SET username=?,password=?,profile=?,active=? WHERE idUser=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getProfile());
            ps.setInt(4, u.getActive());
            ps.setInt(4, u.getIdUser());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean eliminarUsuario(Usuario u) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "DELETE FROM usuario WHERE idUser=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, u.getIdUser());
            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listaUser = new ArrayList<Usuario>();
        try {
            cn = ConexionBD.conectar();
            String sql = "SELECT * FROM usuario";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUser(rs.getInt("idUser"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setProfile(rs.getString("profile"));
                u.setActive(rs.getInt("active"));
                listaUser.add(u);
            }
            cn.close();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaUser;
    }
    
}
