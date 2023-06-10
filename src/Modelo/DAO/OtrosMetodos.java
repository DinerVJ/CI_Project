package Modelo.DAO;

import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author DinerVJ
 */
public class OtrosMetodos {
    //Metodo para Exportar
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
