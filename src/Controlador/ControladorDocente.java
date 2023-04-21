
package Controlador;

import Modelo.DAO.DocenteDAO;
import Modelo.DAO.OtrosMetodos;
import Modelo.DTO.Docente;
import Vista.VistaDocente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorDocente implements ActionListener{

    private Docente dct;
    private DocenteDAO dao;
    private VistaDocente vd;
    private OtrosMetodos om;
    DefaultTableModel dtm = new DefaultTableModel();

    public ControladorDocente(Docente dct, DocenteDAO dao, VistaDocente vd, OtrosMetodos om) {
        this.dct = dct;
        this.dao = dao;
        this.vd = vd;
        this.om = om;
        vd.jbtnRegDct.addActionListener(this);
        vd.jbtnBusDct.addActionListener(this);
        vd.jbtnActDct.addActionListener(this);
        vd.jbtnElmDct.addActionListener(this);
        vd.jbtnExpDct.addActionListener(this);
    }
    
    public void iniciarCtrDct(){
        vd.setTitle("DATOS DEL DOCENTE");
        mostrarEncabezados(vd.jtblDct);
        listarDct();
        
    }
    
    public void mostrarEncabezados(JTable tbl){
        String[] encabezado = {"DNI","APELL. PATERNO","APELL. MATERNO","NOMBRE","SEG. NOMBRE","FEC. DE NAC."};
        DefaultTableModel dtm = new DefaultTableModel(null,encabezado);
        tbl.setModel(dtm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vd.jbtnRegDct) {
            dct.setDniDct(vd.jtxtDniDct.getText());
            dct.setApPatDct(vd.jtxtApPatDct.getText());
            dct.setApMatDct(vd.jtxtApMatDct.getText());
            dct.setNomDct(vd.jtxtNomDct.getText());
            dct.setSgNomDct(vd.jtxtSgNomDct.getText());
            dct.setFecNacDct(vd.jtxtFecNacDct.getText());
            if (dao.crearDocente(dct)) {
                JOptionPane.showMessageDialog(null, "EXITO! Docente registrado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR! No se guardo el registro.");
            }
            listarDct();
        }

        if (e.getSource() == vd.jbtnBusDct) {
            dct.setDniDct(vd.jtxtBusDct.getText());
            if (dao.leerDocente(dct)) {
                vd.jtxtDniDct.setText(dct.getDniDct());
                vd.jtxtApPatDct.setText(dct.getApPatDct());
                vd.jtxtApMatDct.setText(dct.getApMatDct());
                vd.jtxtNomDct.setText(dct.getNomDct());
                vd.jtxtSgNomDct.setText(dct.getSgNomDct());
                vd.jtxtFecNacDct.setText(dct.getFecNacDct());
                vd.jtxtBusDct.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO REGISTRO!");
            }
        }

        if (e.getSource() == vd.jbtnActDct) {
            //alm.setDniAlm(vra.jtxtDniAlm.getText());
            if (dao.actualizarDocente(dct)) {
                dct.setDniDct(vd.jtxtDniDct.getText());
                dct.setApPatDct(vd.jtxtApPatDct.getText());
                dct.setApMatDct(vd.jtxtApMatDct.getText());
                dct.setNomDct(vd.jtxtNomDct.getText());
                dct.setSgNomDct(vd.jtxtSgNomDct.getText());
                dct.setFecNacDct(vd.jtxtFecNacDct.getText());
                if (dao.actualizarDocente(dct)) {
                    JOptionPane.showMessageDialog(null, "EXITO! Registro actualizado.");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR! No se pudo actualizar.");
                }
            }
            listarDct();
        }

        if (e.getSource() == vd.jbtnElmDct) {
            dct.setDniDct(vd.jtxtDniDct.getText());
            if (dao.eliminarDocente(dct)) {
                JOptionPane.showMessageDialog(null, "¡EXITOSO! Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡ERROR! No se eliminó registro");
            }
            listarDct();
        }
        if (e.getSource() == vd.jbtnExpDct) {
            try {
                om.exportarDatosDocente(vd.jtblDct);
            } catch (IOException ex) {
                //Logger.getLogger(ControladorDocente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void limpiar(){
        vd.jtxtDniDct.setText(null);
        vd.jtxtApPatDct.setText(null);
        vd.jtxtApMatDct.setText(null);
        vd.jtxtNomDct.setText(null);
        vd.jtxtSgNomDct.setText(null);
        vd.jtxtFecNacDct.setText(null);
    }
    
    public void listarDct(){
        List<Docente> listarDct = dao.listarDocente();
        dtm = (DefaultTableModel) vd.jtblDct.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < listarDct.size(); i++) {
            ob[0] = listarDct.get(i).getDniDct();
            ob[1] = listarDct.get(i).getApPatDct();
            ob[2] = listarDct.get(i).getApMatDct();
            ob[3] = listarDct.get(i).getNomDct();
            ob[4] = listarDct.get(i).getSgNomDct();
            ob[5] = listarDct.get(i).getFecNacDct();
            dtm.addRow(ob);
        }
        vd.jtblDct.setModel(dtm);
    }
    
}
