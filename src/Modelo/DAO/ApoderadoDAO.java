package Modelo.DAO;

import Modelo.DTO.Apoderado;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ApoderadoDAO implements IntApoderadoDAO {

    private Connection cn;

    @Override
    public boolean crearApoderado(Apoderado apd) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "insert into apoderado(dniApd,apPatApd,apMatApd,nomApd,sgNomApd,fecNacApd)values(?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, apd.getDniApd());
            ps.setString(2, apd.getApPatApd());
            ps.setString(3, apd.getApMatApd());
            ps.setString(4, apd.getNomApd());
            ps.setString(5, apd.getSgNomApd());
            ps.setString(6, apd.getFecNacApd());
            ps.executeUpdate();
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
    public boolean leerApoderado(Apoderado apd) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "select * from apoderado where dniApd=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, apd.getDniApd());
            rs = ps.executeQuery();
            if (rs.next()) {
                apd.setApPatApd(rs.getString("apPatApd"));
                apd.setApMatApd(rs.getString("apMatApd"));
                apd.setNomApd(rs.getString("nomApd"));
                apd.setSgNomApd(rs.getString("sgNomApd"));
                apd.setFecNacApd(rs.getString("fecNacApd"));
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
    public boolean actualizarApoderado(Apoderado apd) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "update apoderado set apPatApd=?,apMatApd=?,nomApd=?,sgNomApd=?,fecNacApd=? where dniApd=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, apd.getApPatApd());
            ps.setString(2, apd.getApMatApd());
            ps.setString(3, apd.getNomApd());
            ps.setString(4, apd.getSgNomApd());
            ps.setString(5, apd.getFecNacApd());
            ps.setString(6, apd.getDniApd());
            ps.execute();
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
    public boolean eliminarApoderado(Apoderado apd) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "delete from apoderado where dniApd=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, apd.getDniApd());
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
    public List<Apoderado> listarApoderado() {
        List<Apoderado> listaApd = new ArrayList<Apoderado>();
        try {
            cn = ConexionBD.conectar();
            String sql = "select * from apoderado";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Apoderado apd = new Apoderado();
                apd.setDniApd(rs.getString("dniApd"));
                apd.setApPatApd(rs.getString("apPatApd"));
                apd.setApMatApd(rs.getString("apMatApd"));
                apd.setNomApd(rs.getString("nomApd"));
                apd.setSgNomApd(rs.getString("sgNomApd"));
                apd.setFecNacApd(rs.getString("fecNacApd"));
                listaApd.add(apd);
            }
            cn.close();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaApd;
    }

}
