package Modelo.DAO;

import Modelo.DTO.Alumno;
import Vista.VistaAlumno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlumnoDAO implements InterAlumnoDAO {

    private Connection cn;

    @Override
    public boolean crearAlumno(Alumno alm) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "insert into alumno(dniAlm,apPatAlm,apMatAlm,nomAlm,sgNomAlm,fecNacAlm,dniApd)values(?,?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getDniAlm());
            ps.setString(2, alm.getApPatAlm());
            ps.setString(3, alm.getApMatAlm());
            ps.setString(4, alm.getNomAlm());
            ps.setString(5, alm.getSgNomAlm());
            ps.setString(6, alm.getFecNacAlm());
            ps.setString(7, alm.getDniApd());
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
                alm.setFecNacAlm(rs.getString("fecNacAlm"));
                alm.setDniApd(rs.getString("dniApd"));
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
        String sql = "update alumno set apPatAlm=?,apMatAlm=?,nomAlm=?,sgNomAlm=?,fecNacAlm=?,dniApd=? where dniAlm=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getApPatAlm());
            ps.setString(2, alm.getApMatAlm());
            ps.setString(3, alm.getNomAlm());
            ps.setString(4, alm.getSgNomAlm());
            ps.setString(5, alm.getFecNacAlm());
            ps.setString(6, alm.getDniApd());
            ps.setString(7, alm.getDniAlm());
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
                alm.setFecNacAlm(rs.getString("fecNacAlm"));
                alm.setDniApd(rs.getString("dniApd"));
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
