/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorAlumno;
import Modelo.DAO.AlumnoDAO;
import Modelo.DTO.Alumno;

/**
 *
 * @author DinerVJ
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        setSize(800, 800);
        jpnlDesk.setSize(750,700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlDesk = new javax.swing.JPanel();
        jdskVistaPrin = new javax.swing.JDesktopPane();
        jmnbVistaPrin = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnuAlm = new javax.swing.JMenu();
        jmniRegAlm = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        jpnlDesk.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jdskVistaPrinLayout = new javax.swing.GroupLayout(jdskVistaPrin);
        jdskVistaPrin.setLayout(jdskVistaPrinLayout);
        jdskVistaPrinLayout.setHorizontalGroup(
            jdskVistaPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jdskVistaPrinLayout.setVerticalGroup(
            jdskVistaPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jpnlDesk.add(jdskVistaPrin, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpnlDesk, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jmnbVistaPrin.add(jMenu1);

        jmnuAlm.setText("Alumno");

        jmniRegAlm.setText("Registrar Alumno");
        jmniRegAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniRegAlmActionPerformed(evt);
            }
        });
        jmnuAlm.add(jmniRegAlm);

        jmnbVistaPrin.add(jmnuAlm);

        setJMenuBar(jmnbVistaPrin);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmniRegAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniRegAlmActionPerformed
        // TODO add your handling code here:
        Alumno alm = new Alumno();
        AlumnoDAO almdao = new AlumnoDAO();
        VistaAlumno vra = new VistaAlumno();
        ControladorAlumno cralm = new ControladorAlumno(alm, almdao, vra);
        cralm.iniciar();
        jdskVistaPrin.add(vra);
        vra.show();
    }//GEN-LAST:event_jmniRegAlmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JDesktopPane jdskVistaPrin;
    private javax.swing.JMenuBar jmnbVistaPrin;
    private javax.swing.JMenuItem jmniRegAlm;
    private javax.swing.JMenu jmnuAlm;
    private javax.swing.JPanel jpnlDesk;
    // End of variables declaration//GEN-END:variables
}
