package Vista;

/**
 *
 * @author DinerVJ
 */
public class VistaAlumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaRegistrarAlumno
     */
    public VistaAlumno() {
        initComponents();
        setSize(730,600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtxtDniAlm = new javax.swing.JTextField();
        jtxtApPatAlm = new javax.swing.JTextField();
        jtxtApMatAlm = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlbNomAlm = new javax.swing.JLabel();
        jlblsgNomAlm = new javax.swing.JLabel();
        jlblfecNacAlm = new javax.swing.JLabel();
        jlbldniApd = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtxtNomAlm = new javax.swing.JTextField();
        jtxtSgNomAlm = new javax.swing.JTextField();
        jtxtFecNacAlm = new javax.swing.JTextField();
        jtxtDniApd = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jbtnRegAlm = new javax.swing.JButton();
        jbtnActAlm = new javax.swing.JButton();
        jbtnElmAlm = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jbtnExpAlm = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jtxtBusAlm = new javax.swing.JTextField();
        jbtnBusAlm = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAlm = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel8.setLayout(new java.awt.GridLayout(3, 1));

        jPanel11.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("DNI:");
        jPanel1.add(jLabel1);

        jLabel2.setText("APELLIDO PATERNO:");
        jPanel1.add(jLabel2);

        jLabel3.setText("APELLIDO MATERNO:");
        jPanel1.add(jLabel3);

        jPanel11.add(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jtxtDniAlm.setOpaque(true);
        jPanel2.add(jtxtDniAlm);
        jPanel2.add(jtxtApPatAlm);
        jPanel2.add(jtxtApMatAlm);

        jPanel11.add(jPanel2);

        jPanel8.add(jPanel11);

        jPanel12.setLayout(new java.awt.GridLayout(2, 1));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jlbNomAlm.setText("NOMBRE:");
        jPanel3.add(jlbNomAlm);

        jlblsgNomAlm.setText("SEGUNDO NOMBRE:");
        jPanel3.add(jlblsgNomAlm);

        jlblfecNacAlm.setText("FECHA DE NACIMIENTO:");
        jPanel3.add(jlblfecNacAlm);

        jlbldniApd.setText("DNI DE APODERADO:");
        jPanel3.add(jlbldniApd);

        jPanel12.add(jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(jtxtNomAlm);
        jPanel4.add(jtxtSgNomAlm);
        jPanel4.add(jtxtFecNacAlm);
        jPanel4.add(jtxtDniApd);

        jPanel12.add(jPanel4);

        jPanel8.add(jPanel12);

        jbtnRegAlm.setText("REGISTRAR");
        jPanel13.add(jbtnRegAlm);

        jbtnActAlm.setText("ACTUALIZAR");
        jPanel13.add(jbtnActAlm);

        jbtnElmAlm.setText("ELIMINAR");
        jPanel13.add(jbtnElmAlm);

        jPanel8.add(jPanel13);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jbtnExpAlm.setText("EXPORTAR");
        jPanel5.add(jbtnExpAlm);

        jPanel9.add(jPanel5);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(jtxtBusAlm);

        jbtnBusAlm.setText("BUSCAR");
        jPanel6.add(jbtnBusAlm);

        jPanel9.add(jPanel6);

        getContentPane().add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jtblAlm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(jtblAlm);

        jPanel10.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtnActAlm;
    public javax.swing.JButton jbtnBusAlm;
    public javax.swing.JButton jbtnElmAlm;
    public javax.swing.JButton jbtnExpAlm;
    public javax.swing.JButton jbtnRegAlm;
    private javax.swing.JLabel jlbNomAlm;
    private javax.swing.JLabel jlbldniApd;
    private javax.swing.JLabel jlblfecNacAlm;
    private javax.swing.JLabel jlblsgNomAlm;
    public javax.swing.JTable jtblAlm;
    public javax.swing.JTextField jtxtApMatAlm;
    public javax.swing.JTextField jtxtApPatAlm;
    public javax.swing.JTextField jtxtBusAlm;
    public javax.swing.JTextField jtxtDniAlm;
    public javax.swing.JTextField jtxtDniApd;
    public javax.swing.JTextField jtxtFecNacAlm;
    public javax.swing.JTextField jtxtNomAlm;
    public javax.swing.JTextField jtxtSgNomAlm;
    // End of variables declaration//GEN-END:variables
}
