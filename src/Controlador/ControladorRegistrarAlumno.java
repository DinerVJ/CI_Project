package Controlador;

import Modelo.DAO.AlumnoDAOImplement;
import Modelo.DTO.Alumno;
import Vista.VistaRegistrarAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorRegistrarAlumno implements ActionListener {

    private Alumno alm;
    private AlumnoDAOImplement dao;
    private VistaRegistrarAlumno vra;

    public ControladorRegistrarAlumno(Alumno alm, AlumnoDAOImplement dao, VistaRegistrarAlumno vra) {
        this.alm = alm;
        this.dao = dao;
        this.vra = vra;
        this.vra.jbtnRegAlm.addActionListener(this);
        this.vra.jbtnActAlm.addActionListener(this);
        this.vra.jbtnElmAlm.addActionListener(this);
        this.vra.jbtnBusAlm.addActionListener(this);
    }

    public void iniciar() {
        vra.setTitle("REGISTRAR ALUMNO");
        vra.setLocation(0, 0);
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
}
