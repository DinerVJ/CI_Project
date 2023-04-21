package Controlador;

import Modelo.DAO.AlumnoDAO;
import Modelo.DTO.Alumno;
import Vista.VistaAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorAlumno implements ActionListener {

    private Alumno alm;
    private AlumnoDAO dao;
    private VistaAlumno vra;
    DefaultTableModel dtblm = new DefaultTableModel();

    public ControladorAlumno(Alumno alm, AlumnoDAO dao, VistaAlumno vra) {
        this.alm = alm;
        this.dao = dao;
        this.vra = vra;
        this.vra.jbtnRegAlm.addActionListener(this);
        this.vra.jbtnActAlm.addActionListener(this);
        this.vra.jbtnElmAlm.addActionListener(this);
        this.vra.jbtnBusAlm.addActionListener(this);
    }

    public void iniciar() {
        vra.setTitle("DATOS DE ALUMNO");
        mostrarEncabezados(vra.jtblAlm);
        listarAlm();
    }

    public void mostrarEncabezados(JTable tbl){
        String[] encabezado = {"DNI","APELL. PATERNO","APELL. MATERNO","NOMBRE","SEG. NOMBRE","FEC. NAC.","DNI APODERADO"};
        DefaultTableModel dtm = new DefaultTableModel(null,encabezado);
        tbl.setModel(dtm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vra.jbtnRegAlm) {
            alm.setDniAlm(vra.jtxtDniAlm.getText());
            alm.setApPatAlm(vra.jtxtApPatAlm.getText());
            alm.setApMatAlm(vra.jtxtApMatAlm.getText());
            alm.setNomAlm(vra.jtxtNomAlm.getText());
            alm.setSgNomAlm(vra.jtxtSgNomAlm.getText());
            alm.setFecNacAlm(vra.jtxtFecNacAlm.getText());
            alm.setDniApd(vra.jtxtDniApd.getText());
            if (dao.crearAlumno(alm)) {
                JOptionPane.showMessageDialog(null, "ALUMNO REGISTRADO EXITOSAMENTE!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR ALUMNO!");
            }
            listarAlm();
        }

        if (e.getSource() == vra.jbtnBusAlm) {
            alm.setDniAlm(vra.jtxtBusAlm.getText());
            if (dao.leerAlumno(alm)) {
                vra.jtxtDniAlm.setText(alm.getDniAlm());
                vra.jtxtApPatAlm.setText(alm.getApPatAlm());
                vra.jtxtApMatAlm.setText(alm.getApMatAlm());
                vra.jtxtNomAlm.setText(alm.getNomAlm());
                vra.jtxtSgNomAlm.setText(alm.getSgNomAlm());
                vra.jtxtFecNacAlm.setText(alm.getFecNacAlm());
                vra.jtxtDniApd.setText(alm.getDniApd());
                vra.jtxtBusAlm.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO REGISTRO!");
            }
        }

        if (e.getSource() == vra.jbtnActAlm) {
            //alm.setDniAlm(vra.jtxtDniAlm.getText());
            if (dao.actualizarAlumno(alm)) {
                alm.setDniAlm(vra.jtxtDniAlm.getText());
                alm.setApPatAlm(vra.jtxtApPatAlm.getText());
                alm.setApMatAlm(vra.jtxtApMatAlm.getText());
                alm.setNomAlm(vra.jtxtNomAlm.getText());
                alm.setSgNomAlm(vra.jtxtSgNomAlm.getText());
                alm.setFecNacAlm(vra.jtxtFecNacAlm.getText());
                alm.setDniApd(vra.jtxtDniApd.getText());
                if (dao.actualizarAlumno(alm)) {
                    JOptionPane.showMessageDialog(null, "EXITO! Registro actualizado.");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR! No se pudo actualizar.");
                }
            }
            dao.listarAlumno();
        }

        if (e.getSource() == vra.jbtnElmAlm) {
            alm.setDniApd(vra.jtxtDniApd.getText());
            if (dao.eliminarAlumno(alm)) {
                JOptionPane.showMessageDialog(null, "¡EXITOSO! Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡ERROR! No se eliminó registro");
            }
        }
    }

    public void limpiar() {
        vra.jtxtDniAlm.setText(null);
        vra.jtxtApPatAlm.setText(null);
        vra.jtxtApMatAlm.setText(null);
        vra.jtxtNomAlm.setText(null);
        vra.jtxtSgNomAlm.setText(null);
        vra.jtxtFecNacAlm.setText(null);
        vra.jtxtDniApd.setText(null);
    }
    
    public void listarAlm(){
        List<Alumno> listarAlm = dao.listarAlumno();
        dtblm = (DefaultTableModel) vra.jtblAlm.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < listarAlm.size(); i++) {
            ob[0] = listarAlm.get(i).getDniAlm();
            ob[1] = listarAlm.get(i).getApPatAlm();
            ob[2] = listarAlm.get(i).getApMatAlm();
            ob[3] = listarAlm.get(i).getNomAlm();
            ob[4] = listarAlm.get(i).getSgNomAlm();
            ob[5] = listarAlm.get(i).getFecNacAlm();
            ob[6] = listarAlm.get(i).getDniApd();
            dtblm.addRow(ob);
        }
        vra.jtblAlm.setModel(dtblm);
    }
}
