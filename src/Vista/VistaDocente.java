/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author DinerVJ
 */
public class VistaDocente extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaRegistrarDocente
     */
    public VistaDocente() {
        initComponents();
        setSize(730, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtxtDniDct = new javax.swing.JTextField();
        jtxtApPatDct = new javax.swing.JTextField();
        jtxtApMatDct = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jtxtNomDct = new javax.swing.JTextField();
        jtxtSgNomDct = new javax.swing.JTextField();
        jdtcFecNacDct = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jbtnRegDct = new javax.swing.JButton();
        jbtnActDct = new javax.swing.JButton();
        jbtnElmDct = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jbtnExpDct = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jtxtBusDct = new javax.swing.JTextField();
        jbtnBusDct = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDct = new javax.swing.JTable();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("DNI:");
        jPanel8.add(jLabel1);

        jLabel2.setText("APELLIDO PATERNO:");
        jPanel8.add(jLabel2);

        jLabel3.setText("APELLIDO MATERNO:");
        jPanel8.add(jLabel3);

        jPanel4.add(jPanel8);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));
        jPanel9.add(jtxtDniDct);
        jPanel9.add(jtxtApPatDct);
        jPanel9.add(jtxtApMatDct);

        jPanel4.add(jPanel9);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("NOMBRE:");
        jPanel10.add(jLabel4);

        jLabel5.setText("SEGUNDO NOMBRE:");
        jPanel10.add(jLabel5);

        jLabel6.setText("FECHA DE NACIMIENTO:");
        jPanel10.add(jLabel6);

        jPanel5.add(jPanel10);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));
        jPanel11.add(jtxtNomDct);
        jPanel11.add(jtxtSgNomDct);
        jPanel11.add(jdtcFecNacDct);

        jPanel5.add(jPanel11);

        jPanel2.add(jPanel5);

        jbtnRegDct.setText("REGISTRAR");
        jPanel6.add(jbtnRegDct);

        jbtnActDct.setText("ACTUALIZAR");
        jPanel6.add(jbtnActDct);

        jbtnElmDct.setText("ELIMINAR");
        jPanel6.add(jbtnElmDct);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jbtnExpDct.setText("EXPORTAR");
        jPanel12.add(jbtnExpDct);

        jPanel3.add(jPanel12);

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));
        jPanel13.add(jtxtBusDct);

        jbtnBusDct.setText("BUSCAR");
        jPanel13.add(jbtnBusDct);

        jPanel3.add(jPanel13);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jtblDct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblDct);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtnActDct;
    public javax.swing.JButton jbtnBusDct;
    public javax.swing.JButton jbtnElmDct;
    public javax.swing.JButton jbtnExpDct;
    public javax.swing.JButton jbtnRegDct;
    public com.toedter.calendar.JDateChooser jdtcFecNacDct;
    public javax.swing.JTable jtblDct;
    public javax.swing.JTextField jtxtApMatDct;
    public javax.swing.JTextField jtxtApPatDct;
    public javax.swing.JTextField jtxtBusDct;
    public javax.swing.JTextField jtxtDniDct;
    public javax.swing.JTextField jtxtNomDct;
    public javax.swing.JTextField jtxtSgNomDct;
    // End of variables declaration//GEN-END:variables
}
