package Modelo.DAO;

import Modelo.DTO.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements IntAlumnoDAO {

    private Connection cn;

    @Override
    public boolean crearAlumno(Alumno alm) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "insert into alumno(dniAlm,apPatAlm,apMatAlm,nomAlm,sgNomAlm,fecNacAlm,dniApd,gradoAlm,seccionAlm)values(?,?,?,?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getDniAlm());
            ps.setString(2, alm.getApPatAlm());
            ps.setString(3, alm.getApMatAlm());
            ps.setString(4, alm.getNomAlm());
            ps.setString(5, alm.getSgNomAlm());
            ps.setDate(6, new java.sql.Date(alm.getFecNacAlm().getTime()));
            ps.setString(7, alm.getDniApd());
            ps.setString(8, alm.getGradoAlm());
            ps.setString(9, alm.getSeccionAlm());
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
    public boolean leerAlumno(Alumno alm) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "select * from alumno where dniAlm=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getDniAlm());
            rs = ps.executeQuery();
            if (rs.next()) {
                alm.setApPatAlm(rs.getString("apPatAlm"));
                alm.setApMatAlm(rs.getString("apMatAlm"));
                alm.setNomAlm(rs.getString("nomAlm"));
                alm.setSgNomAlm(rs.getString("sgNomAlm"));
                alm.setFecNacAlm(rs.getDate("fecNacAlm"));
                alm.setDniApd(rs.getString("dniApd"));
                alm.setGradoAlm(rs.getString("gradoAlm"));
                alm.setSeccionAlm(rs.getString("seccionAlm"));
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
    public boolean actualizarAlumno(Alumno alm) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "update alumno set apPatAlm=?,apMatAlm=?,nomAlm=?,sgNomAlm=?,fecNacAlm=?,dniApd=?,gradoAlm=?,seccion=? where dniAlm=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getApPatAlm());
            ps.setString(2, alm.getApMatAlm());
            ps.setString(3, alm.getNomAlm());
            ps.setString(4, alm.getSgNomAlm());
            ps.setDate(5, (Date) alm.getFecNacAlm());
            ps.setString(6, alm.getDniApd());
            ps.setString(7, alm.getDniAlm());
            ps.setString(8, alm.getGradoAlm());
            ps.setString(9, alm.getSeccionAlm());
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
    public boolean eliminarAlumno(Alumno alm) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "delete from alumno where dniAlm=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getDniAlm());
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
    public List<Alumno> listarAlumno() {
        List<Alumno> listaAlm = new ArrayList<Alumno>();
        try {
            cn = ConexionBD.conectar();
            String sql = "select * from alumno";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alm = new Alumno();
                alm.setDniAlm(rs.getString("dniAlm"));
                alm.setApPatAlm(rs.getString("apPatAlm"));
                alm.setApMatAlm(rs.getString("apMatAlm"));
                alm.setNomAlm(rs.getString("nomAlm"));
                alm.setSgNomAlm(rs.getString("sgNomAlm"));
                alm.setFecNacAlm(rs.getDate("fecNacAlm"));
                alm.setDniApd(rs.getString("dniApd"));
                alm.setGradoAlm(rs.getString("gradoAlm"));
                alm.setSeccionAlm(rs.getString("seccionAlm"));
                listaAlm.add(alm);
            }
            cn.close();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaAlm;

    }

}
