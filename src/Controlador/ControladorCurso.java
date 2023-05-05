package Controlador;

import Modelo.DAO.CursoDAO;
import Modelo.DAO.OtrosMetodos;
import Modelo.DTO.Curso;
import Vista.VistaCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCurso implements ActionListener{
    //ATRIBUTOS
    private Curso c;
    private CursoDAO dao;
    private VistaCurso vc;
    private OtrosMetodos om;
    private DefaultTableModel dtm;
    //Metodo CONSTRUCTOR con PARAMETROS
    public ControladorCurso(Curso c, CursoDAO dao, VistaCurso vc, OtrosMetodos om) {
        this.c = c;
        this.dao = dao;
        this.vc = vc;
        this.om = om;
        this.dtm = dtm;
        this.vc.jbtnCrearCrs.addActionListener(this);
        this.vc.jtxtBusCrs.addActionListener(this);
        this.vc.jbtnActCur.addActionListener(this);
        this.vc.jtbnElmCur.addActionListener(this);
    }
    //Metodo de INICIO
    public void iniciar() {
        vc.setTitle("DATOS DEL ALUMNO");
        mostrarEncabezados(vc.jtblCur);
        listarCur();
    }
    //Metodo para determinar ENCABEZADOS de la tabla
    public void mostrarEncabezados(JTable tbl) {
        String[] encabezado = {"ID","NOMBRE"};
        DefaultTableModel dtm = new DefaultTableModel(null, encabezado);
        tbl.setModel(dtm);
    }
    //Metodo 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vc.jbtnCrearCrs) {
            limpiarListaCur(vc.jtblCur);
            c.setNomCur(vc.jtxtNomCrs.getText());
            if (dao.crearCurso(c)) {
                JOptionPane.showMessageDialog(null, "CURSO REGISTRADO EXITOSAMENTE!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR CURSO!");
            }
            listarCur();
        }
        if (e.getSource() == vc.jbtnBusCrs) {
            limpiarListaCur(vc.jtblCur);
            c.setIdCur(Integer.parseInt(vc.jtxtBusCrs.getText()));
            if (dao.leerCurso(c)) {
                vc.jtxtNomCrs.setText(c.getNomCur());
                //vc.jtxtBusCrs.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO REGISTRO!");
            }
        }
        if (e.getSource() == vc.jbtnActCur) {
            limpiarListaCur(vc.jtblCur);
            c.setNomCur(vc.jtxtNomCrs.getText());
            c.setIdCur(Integer.parseInt(vc.jtxtBusCrs.getText()));
            if (dao.actualizarCurso(c)) {
                JOptionPane.showMessageDialog(null, "EXITO! Curso actualizado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR! No se pudo actualizar.");
            }
            listarCur();
        }
    }
    //Metodo para LISTAR
    public void listarCur() {
        List<Curso> listarCur = dao.listarCurso();
        dtm = (DefaultTableModel) vc.jtblCur.getModel();
        Object[] ob = new Object[2];
        for (int i = 0; i < listarCur.size(); i++) {
            ob[0] = listarCur.get(i).getIdCur();
            ob[1] = listarCur.get(i).getNomCur();
            dtm.addRow(ob);
        }
        vc.jtblCur.setModel(dtm);
    }
    //Metodo para LIMPIAR registros de la tabla ALUMNOS
    public void limpiarListaCur(JTable jtblAlm){
        if (vc.jtblCur != null) {
            dtm.setRowCount(0);
        }
    }
    //Metodo para LIMPIAR CAMPOS
    public void limpiar(){
        vc.jtxtNomCrs.setText(null);
    }
}
