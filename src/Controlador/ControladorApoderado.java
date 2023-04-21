
package Controlador;

import Modelo.DAO.ApoderadoDAO;
import Modelo.DTO.Apoderado;
import Vista.VistaApoderado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorApoderado implements ActionListener{
    
    private Apoderado apd;
    private ApoderadoDAO dao;
    private VistaApoderado vap;
    DefaultTableModel dtm = new DefaultTableModel();

    public ControladorApoderado(Apoderado apd, ApoderadoDAO dao, VistaApoderado vap) {
        this.apd = apd;
        this.dao = dao;
        this.vap = vap;
    }
    
    public void iniciarCtrApd(){
        vap.setTitle("DATOS DE APODERADO");
        mostrarEncabezados(vap.jtblApd);
        listarApd();
    }
    
    public void mostrarEncabezados(JTable tbl){
        String[] encabezado = {"DNI","APELL. PATERNO","APELL. MATERNO","NOMBRE","SEG. NOMBRE","FEC. NAC."};
        DefaultTableModel dtm = new DefaultTableModel(null,encabezado);
        tbl.setModel(dtm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vap.jbtnRegApd) {
            apd.setDniApd(vap.jtxtDniApd.getText());
            apd.setApPatApd(vap.jtxtApPatApd.getText());
            apd.setApMatApd(vap.jtxtApMatApd.getText());
            apd.setNomApd(vap.jtxtNomApd.getText());
            apd.setSgNomApd(vap.jtxtSgNomApd.getText());
            apd.setFecNacApd(vap.jtxtFecNacApd.getText());
            if (dao.crearApoderado(apd)) {
                JOptionPane.showMessageDialog(null, "ALUMNO REGISTRADO EXITOSAMENTE!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR ALUMNO!");
            }
            listarApd();
        }

        if (e.getSource() == vap.jbtnBusApd) {
            apd.setDniApd(vap.jtxtBusApd.getText());
            if (dao.leerApoderado(apd)) {
                vap.jtxtDniApd.setText(apd.getDniApd());
                vap.jtxtApPatApd.setText(apd.getApPatApd());
                vap.jtxtApMatApd.setText(apd.getApMatApd());
                vap.jtxtNomApd.setText(apd.getNomApd());
                vap.jtxtSgNomApd.setText(apd.getSgNomApd());
                vap.jtxtFecNacApd.setText(apd.getFecNacApd());
                vap.jtxtBusApd.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO REGISTRO!");
            }
        }

        if (e.getSource() == vap.jbtnActApd) {
            //alm.setDniAlm(vra.jtxtDniAlm.getText());
            if (dao.actualizarApoderado(apd)) {
                apd.setDniApd(vap.jtxtDniApd.getText());
                apd.setApPatApd(vap.jtxtApPatApd.getText());
                apd.setApMatApd(vap.jtxtApMatApd.getText());
                apd.setNomApd(vap.jtxtNomApd.getText());
                apd.setSgNomApd(vap.jtxtSgNomApd.getText());
                apd.setFecNacApd(vap.jtxtFecNacApd.getText());
                if (dao.actualizarApoderado(apd)) {
                    JOptionPane.showMessageDialog(null, "EXITO! Registro actualizado.");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR! No se pudo actualizar.");
                }
            }
            listarApd();
        }

        if (e.getSource() == vap.jbtnElmApd) {
            apd.setDniApd(vap.jtxtDniApd.getText());
            if (dao.eliminarApoderado(apd)) {
                JOptionPane.showMessageDialog(null, "¡EXITOSO! Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡ERROR! No se eliminó registro");
            }
            listarApd();
        }
    }
    
    public void limpiar(){
        vap.jtxtDniApd.setText(null);
        vap.jtxtApPatApd.setText(null);
        vap.jtxtApMatApd.setText(null);
        vap.jtxtNomApd.setText(null);
        vap.jtxtSgNomApd.setText(null);
        vap.jtxtFecNacApd.setText(null);
    }
    
    public void listarApd(){
        List<Apoderado> listarApd = dao.listarApoderado();
        dtm = (DefaultTableModel) vap.jtblApd.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < listarApd.size(); i++) {
            ob[0] = listarApd.get(i).getDniApd();
            ob[1] = listarApd.get(i).getApPatApd();
            ob[2] = listarApd.get(i).getApMatApd();
            ob[3] = listarApd.get(i).getNomApd();
            ob[4] = listarApd.get(i).getSgNomApd();
            ob[5] = listarApd.get(i).getFecNacApd();
            dtm.addRow(ob);
        }
        vap.jtblApd.setModel(dtm);
    }
    
}
