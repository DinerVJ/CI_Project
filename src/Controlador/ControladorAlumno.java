package Controlador;

import Modelo.DAO.AlumnoDAO;
import Modelo.DAO.OtrosMetodos;
import Modelo.DTO.Alumno;
import Vista.VistaAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorAlumno implements ActionListener {
    //ATRIBUTOS
    private Alumno alm;
    private AlumnoDAO dao;
    private VistaAlumno vra;
    private OtrosMetodos om;
    DefaultTableModel dtblm = new DefaultTableModel();
    //Metodo CONSTRUCTO con PARAMETROS
    public ControladorAlumno(Alumno alm, AlumnoDAO dao, VistaAlumno vra, OtrosMetodos om) {
        this.alm = alm;
        this.dao = dao;
        this.vra = vra;
        this.om = om;
        this.vra.jbtnRegAlm.addActionListener(this);
        this.vra.jbtnActAlm.addActionListener(this);
        this.vra.jbtnElmAlm.addActionListener(this);
        this.vra.jbtnBusAlm.addActionListener(this);
        this.vra.jbtnExpAlm.addActionListener(this);
    }
    // Metodo de INICIO
    public void iniciar() {
        vra.setTitle("DATOS DEL ALUMNO");
        mostrarEncabezados(vra.jtblAlm);
        listarAlm();
        formatoFecha();
        opcCombBox();
    }
    //Metodo para determinar ENCABEZADOS de la tabla
    public void mostrarEncabezados(JTable tbl) {
        String[] encabezado = {"DNI", "APELL. PATERNO", "APELL. MATERNO", "NOMBRE", "SEG. NOMBRE", "FEC. NAC.", "DNI APODERADO", "GRADO", "SECCION"};
        DefaultTableModel dtm = new DefaultTableModel(null, encabezado);
        tbl.setModel(dtm);
    }
    //Metodo de ACCIONES
    @Override
    public void actionPerformed(ActionEvent e) {
        //Condicional para REGISTRAR
        if (e.getSource() == vra.jbtnRegAlm) {
            limpiarListaAlm(vra.jtblAlm);
            alm.setDniAlm(vra.jtxtDniAlm.getText());
            alm.setApPatAlm(vra.jtxtApPatAlm.getText());
            alm.setApMatAlm(vra.jtxtApMatAlm.getText());
            alm.setNomAlm(vra.jtxtNomAlm.getText());
            alm.setSgNomAlm(vra.jtxtSgNomAlm.getText());
            alm.setFecNacAlm(vra.jdtcFecNacAlm.getDate());
            alm.setDniApd(vra.jtxtDniApd.getText());
            alm.setGradoAlm(vra.jcbGradoAlm.getSelectedItem().toString());
            alm.setSeccionAlm(vra.jcbxSecAlm.getSelectedItem().toString());
            if (dao.crearAlumno(alm)) {
                JOptionPane.showMessageDialog(null, "ALUMNO REGISTRADO EXITOSAMENTE!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR ALUMNO!");
            }
            listarAlm();
        }
        //Condicional para BUSCAR
        if (e.getSource() == vra.jbtnBusAlm) {
            alm.setDniAlm(vra.jtxtBusAlm.getText());
            if (dao.leerAlumno(alm)) {
                vra.jtxtDniAlm.setText(alm.getDniAlm());
                vra.jtxtApPatAlm.setText(alm.getApPatAlm());
                vra.jtxtApMatAlm.setText(alm.getApMatAlm());
                vra.jtxtNomAlm.setText(alm.getNomAlm());
                vra.jtxtSgNomAlm.setText(alm.getSgNomAlm());
                vra.jdtcFecNacAlm.setDate(alm.getFecNacAlm());
                vra.jtxtDniApd.setText(alm.getDniApd());
                vra.jcbGradoAlm.setSelectedItem(alm.getGradoAlm());
                vra.jcbxSecAlm.setSelectedItem(alm.getSeccionAlm());
                vra.jtxtBusAlm.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO REGISTRO!");
            }
        }
        //Condicional para ACTUALIZAR
        if (e.getSource() == vra.jbtnActAlm) {
            limpiarListaAlm(vra.jtblAlm);
            alm.setApPatAlm(vra.jtxtApPatAlm.getText());
            alm.setApMatAlm(vra.jtxtApMatAlm.getText());
            alm.setNomAlm(vra.jtxtNomAlm.getText());
            alm.setSgNomAlm(vra.jtxtSgNomAlm.getText());
            alm.setFecNacAlm(vra.jdtcFecNacAlm.getDate());
            alm.setDniApd(vra.jtxtDniApd.getText());
            alm.setGradoAlm(vra.jcbGradoAlm.getSelectedItem().toString());
            alm.setSeccionAlm(vra.jcbxSecAlm.getSelectedItem().toString());
            alm.setDniAlm(vra.jtxtDniAlm.getText());
            if (dao.actualizarAlumno(alm)) {
                JOptionPane.showMessageDialog(null, "EXITO! Registro actualizado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR! No se pudo actualizar.");
            }
            listarAlm();
        }
        //Condicional para ELIMINAR
        if (e.getSource() == vra.jbtnElmAlm) {
            limpiarListaAlm(vra.jtblAlm);
            alm.setDniApd(vra.jtxtDniApd.getText());
            if (dao.eliminarAlumno(alm)) {
                JOptionPane.showMessageDialog(null, "¡EXITOSO! Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡ERROR! No se eliminó registro");
            }
            listarAlm();
        }
        //Condicional para EXPORTAR datos a EXCEL
        if (e.getSource() == vra.jbtnExpAlm) {
            try {
                om.exportarDatosDocente(vra.jtblAlm);
            } catch (IOException ex) {
                //Logger.getLogger(ControladorDocente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Metodo para LISTAR
    public void listarAlm() {
        List<Alumno> listarAlm = dao.listarAlumno();
        dtblm = (DefaultTableModel) vra.jtblAlm.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < listarAlm.size(); i++) {
            ob[0] = listarAlm.get(i).getDniAlm();
            ob[1] = listarAlm.get(i).getApPatAlm();
            ob[2] = listarAlm.get(i).getApMatAlm();
            ob[3] = listarAlm.get(i).getNomAlm();
            ob[4] = listarAlm.get(i).getSgNomAlm();
            ob[5] = listarAlm.get(i).getFecNacAlm();
            ob[6] = listarAlm.get(i).getDniApd();
            ob[7] = listarAlm.get(i).getGradoAlm();
            ob[8] = listarAlm.get(i).getSeccionAlm();
            dtblm.addRow(ob);
        }
        vra.jtblAlm.setModel(dtblm);
    }
    //Metodo para LIMPIAR registros de la tabla ALUMNOS
    public void limpiarListaAlm(JTable jtblAlm){
        if (vra.jtblAlm != null) {
            dtblm.setRowCount(0);
        }
    }
    //Metodo para DAR FORMATO a la FECHA
    public void formatoFecha() {
        vra.jdtcFecNacAlm.setDateFormatString("yyyy-MM-dd");
    }
    //Metodo para GUARDAR FECHA
    public void guadarFecha() {
        Date fecSelect = vra.jdtcFecNacAlm.getDate();
        alm.setFecNacAlm(fecSelect);
    }
    //Metodo para LIMPIAR CAMPOS de texto
    public void limpiar() {
        vra.jtxtDniAlm.setText(null);
        vra.jtxtApPatAlm.setText(null);
        vra.jtxtApMatAlm.setText(null);
        vra.jtxtNomAlm.setText(null);
        vra.jtxtSgNomAlm.setText(null);
        vra.jdtcFecNacAlm.setDate(null);
        vra.jtxtDniApd.setText(null);
        vra.jcbGradoAlm.setSelectedItem(null);
        vra.jcbxSecAlm.setSelectedItem(null);
    }
    //Metodo para INGRESAR OPCIONES al combo box
    public void opcCombBox(){
        vra.jcbGradoAlm.addItem("PRIMERO");
        vra.jcbGradoAlm.addItem("SEGUNDO");
        vra.jcbGradoAlm.addItem("TERCERO");
        vra.jcbGradoAlm.addItem("CUARTO");
        vra.jcbGradoAlm.addItem("QUINTO");
        vra.jcbxSecAlm.addItem("A");
        vra.jcbxSecAlm.addItem("B");
    }
}
