
package Controlador;

import Modelo.DAO.DocenteDAO;
import Modelo.DTO.Docente;
import Vista.VistaDocente;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ControladorDocente implements ActionListener{

    private Docente dct;
    private DocenteDAO dao;
    private VistaDocente vd;
    DefaultTableModel dtm = new DefaultTableModel();

    public ControladorDocente(Docente dct, DocenteDAO dao, VistaDocente vd) {
        this.dct = dct;
        this.dao = dao;
        this.vd = vd;
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
                exportarDatosDocente(vd.jtblDct);
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
    
    public void exportarDatosDocente(JTable jtbl) throws IOException{
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ReportesExcel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                } else {
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Datos de Docentes");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < jtbl.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < jtbl.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(jtbl.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < jtbl.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < jtbl.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (jtbl.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(jtbl.getValueAt(f, c).toString()));
                        } else if (jtbl.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String)jtbl.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(jtbl.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }
}
