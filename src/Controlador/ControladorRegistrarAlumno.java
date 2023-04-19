
package Controlador;

import Modelo.DAO.AlumnoDAOImplement;
import Modelo.DTO.Alumno;
import Vista.VistaRegistrarAlumno;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorRegistrarAlumno {
    private Alumno alm;
    private AlumnoDAOImplement dao;
    private VistaRegistrarAlumno vra;
    
    public ControladorRegistrarAlumno(Alumno alm, AlmDAOImpl dao, VistaRegAlm vra){
        this.alm = alm;
        this.dao = dao;
        this.vra = vra;
        this.vra.jbtnRegAlm.addActionListener(this);
        this.vra.jbtnActAlm.addActionListener(this);
        this.vra.jbtnDelAlm.addActionListener(this);
        this.vra.jbtnDelAlm.addActionListener(this);
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
    }
    
    public void limpiar(){
        vra.jtxtDniAlm.setText(null);
        vra.jtxtApPatAlm.setText(null);
        vra.jtxtApMatAlm.setText(null);
        vra.jtxtNomAlm.setText(null);
        vra.jtxtSgNomAlm.setText(null);
        vra.jtxtFecNacAlm.setText(null);
        vra.jtxtDniApd.setText(null);
    }
}
