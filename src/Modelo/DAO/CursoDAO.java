package Modelo.DAO;

import Modelo.DTO.Curso;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class CursoDAO implements IntCursoDAO{

    private Connection cn;
    
    @Override
    public boolean crearCurso(Curso c) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "INSERT INTO curso(nomCur)VALUES(?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNomCur());
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
    public boolean leerCurso(Curso c) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "SELECT * FROM curso WHERE idCur=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, c.getIdCur());
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setNomCur(rs.getString("nomCur"));
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
    public boolean actualizarCurso(Curso c) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "UPDATE curso SET nomCur=? WHERE idCur=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNomCur());
            ps.setInt(2, c.getIdCur());
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
    public boolean eliminarCurso(Curso c) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "DELETE FROM curso WHERE idCur=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, c.getIdCur());
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
    public List<Curso> listarCurso() {
        List<Curso> listaCur = new ArrayList<Curso>();
        try {
            cn = ConexionBD.conectar();
            String sql = "SELECT * FROM curso";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                c.setIdCur(rs.getInt("idCur"));
                c.setNomCur(rs.getString("nomCur"));
                listaCur.add(c);
            }
            cn.close();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaCur;
    }
    
}
