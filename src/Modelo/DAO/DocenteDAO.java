package Modelo.DAO;

import Modelo.DTO.Docente;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DocenteDAO implements IntDocenteDAO{

    private Connection cn;
    
    @Override
    public boolean crearDocente(Docente dct) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "insert into docente(dniDct,apPatDct,apMatDct,nomDct,sgNomDct,fecNacDct)values(?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dct.getDniDct());
            ps.setString(2, dct.getApPatDct());
            ps.setString(3, dct.getApMatDct());
            ps.setString(4, dct.getNomDct());
            ps.setString(5, dct.getSgNomDct());
            ps.setString(6, dct.getFecNacDct());
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
    public boolean leerDocente(Docente dct) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "select * from docente where dniADct=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dct.getDniDct());
            rs = ps.executeQuery();
            if (rs.next()) {
                dct.setApPatDct(rs.getString("apPatDct"));
                dct.setApMatDct(rs.getString("apMatDct"));
                dct.setNomDct(rs.getString("nomDct"));
                dct.setSgNomDct(rs.getString("sgNomDct"));
                dct.setFecNacDct(rs.getString("fecNacDct"));
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
    public boolean actualizarDocente(Docente dct) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "update alumno set apPatDct=?,apMatDct=?,nomDct=?,sgNomDct=?,fecNacDct=? where dniDct=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dct.getApPatDct());
            ps.setString(2,dct.getApMatDct());
            ps.setString(3, dct.getNomDct());
            ps.setString(4, dct.getSgNomDct());
            ps.setString(5, dct.getFecNacDct());
            ps.setString(6, dct.getDniDct());
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
    public boolean eliminarDocente(Docente dct) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "delete from docente where dniDct=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dct.getDniDct());
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
    public List<Docente> listarDocente() {
        List<Docente> listaDct = new ArrayList<Docente>();
        try {
            cn = ConexionBD.conectar();
            String sql = "select * from docente";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Docente alm = new Docente();
                alm.setDniDct(rs.getString("dniDct"));
                alm.setApPatDct(rs.getString("apPatDct"));
                alm.setApMatDct(rs.getString("apMatDct"));
                alm.setNomDct(rs.getString("nomDct"));
                alm.setSgNomDct(rs.getString("sgNomDct"));
                alm.setFecNacDct(rs.getString("fecNacDct"));
                listaDct.add(alm);
            }
            cn.close();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaDct;
    }
    
}
