package Modelo.DAO;

import Modelo.DTO.Alumno;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AlumnoDAO implements IntAlumnoDAO {

    private Connection cn;

    @Override
    public boolean crearAlumno(Alumno alm) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "INSERT INTO alumno(dniAlm,apPatAlm,apMatAlm,nomAlm,sgNomAlm,fecNacAlm,dniApd,gradoAlm,seccionAlm)VALUES(?,?,?,?,?,?,?,?,?)";
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
    public boolean leerAlumno(Alumno alm) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        String sql = "SELECT * FROM alumno WHERE dniAlm=?";
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
        String sql = "UPDATE alumno SET apPatAlm=?,apMatAlm=?,nomAlm=?,sgNomAlm=?,fecNacAlm=?,dniApd=?,gradoAlm=?,seccionAlm=? WHERE dniAlm=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, alm.getApPatAlm());
            ps.setString(2, alm.getApMatAlm());
            ps.setString(3, alm.getNomAlm());
            ps.setString(4, alm.getSgNomAlm());
            ps.setDate(5, new java.sql.Date(alm.getFecNacAlm().getTime()));
            ps.setString(6, alm.getDniApd());
            ps.setString(7, alm.getGradoAlm());
            ps.setString(8, alm.getSeccionAlm());
            ps.setString(9, alm.getDniAlm());
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
    public boolean eliminarAlumno(Alumno alm) {
        PreparedStatement ps = null;
        cn = ConexionBD.conectar();
        String sql = "DELETE FROM alumno WHERE dniAlm=?";
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
            String sql = "SELECT * FROM alumno";
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

    public void exportarDatosPDF() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn = ConexionBD.conectar();
        Document d = new Document();
        try {
            //String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(d, new FileOutputStream("src/pdf-reports/reporte.pdf"));
            d.open();
            
            PdfPTable tbpdf = new PdfPTable(9);
            tbpdf.addCell("DNI");
            tbpdf.addCell("Apellido Paterno");
            tbpdf.addCell("Apellido Materno");
            tbpdf.addCell("Nombre");
            tbpdf.addCell("Segundo Nombre");
            tbpdf.addCell("Fecha Nacimiento");
            tbpdf.addCell("DNI de Apoderado");
            tbpdf.addCell("Grado");
            tbpdf.addCell("Sección");
            try {
                ps = cn.prepareStatement("SELECT * FROM alumno");
                rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tbpdf.addCell(rs.getString(1));
                        tbpdf.addCell(rs.getString(2));
                        tbpdf.addCell(rs.getString(3));
                        tbpdf.addCell(rs.getString(4));
                        tbpdf.addCell(rs.getString(5));
                        tbpdf.addCell(rs.getString(6));
                        tbpdf.addCell(rs.getString(7));
                        tbpdf.addCell(rs.getString(8));
                        tbpdf.addCell(rs.getString(9));
                    } while (rs.next());
                    d.add(tbpdf);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe boleta para el dni indicado");
                }
            } catch (Exception e) {
            }
            d.close();
            
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error " + e);
        } 
    }
}
