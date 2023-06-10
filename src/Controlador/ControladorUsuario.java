
package Controlador;

import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.Usuario;
import Vista.VistaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuario implements ActionListener{

    private Usuario u;
    private UsuarioDAO dao;
    private VistaUsuario vu;
    DefaultTableModel dtblm = new DefaultTableModel();

    public ControladorUsuario(Usuario u, UsuarioDAO dao, VistaUsuario vu) {
        this.u = u;
        this.dao = dao;
        this.vu = vu;
        this.vu.jbtnRegistrarUser.addActionListener(this);
    }
    
    public void Iniciar(){
        vu.setTitle("DATOS DEL USUARIO");
        mostrarEncabezados(vu.jtblUser);
        listarUser();
        opcCombBox();
    }
    //Metodo para determinar ENCABEZADOS de la tabla
    public void mostrarEncabezados(JTable tbl) {
        String[] encabezado = {"ID", "USUARIO", "CONTRASEÑA", "PERFIL", "ESTADO"};
        DefaultTableModel dtm = new DefaultTableModel(null, encabezado);
        tbl.setModel(dtm);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vu.jbtnRegistrarUser) {
            limpiarListaUser(vu.jtblUser);
            u.setUsername(vu.jtxtUsername.getText());
            u.setPassword(vu.jtxtPassword.getText());
            u.setProfile(vu.jcbProfile.getSelectedItem().toString());
            u.setActive(Integer.parseInt((String) vu.jcbActive.getSelectedItem()));
            if (dao.crearUsuario(u)) {
                JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO EXITOSAMENTE!");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR ALUMNO!");
            }
            listarUser();
        }
    }
    //Metodo para LISTAR
    public void listarUser() {
        List<Usuario> listarUser = dao.listarUsuario();
        dtblm = (DefaultTableModel) vu.jtblUser.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < listarUser.size(); i++) {
            ob[0] = listarUser.get(i).getIdUser();
            ob[1] = listarUser.get(i).getUsername();
            ob[2] = listarUser.get(i).getPassword();
            ob[3] = listarUser.get(i).getProfile();
            ob[4] = listarUser.get(i).getActive();
            dtblm.addRow(ob);
        }
        vu.jtblUser.setModel(dtblm);
    }
    //Metodo para LIMPIAR registros de la tabla
    public void limpiarListaUser(JTable jtblAlm){
        if (vu.jtblUser != null) {
            dtblm.setRowCount(0);
        }
    }
    //Metodo para LIMPIAR CAMPOS de texto
    public void limpiar() {
        vu.jtxtUsername.setText(null);
        vu.jtxtPassword.setText(null);
        vu.jcbProfile.setSelectedItem(1);
        vu.jcbActive.setSelectedItem(1);
    }
    //Metodo para INGRESAR OPCIONES al combo box
    public void opcCombBox(){
        vu.jcbProfile.addItem("--SELECCIONAR--");
        vu.jcbProfile.addItem("ADMINISTRADO");
        vu.jcbProfile.addItem("SECRETARIO/A");
        vu.jcbProfile.addItem("DOCENTE");
        vu.jcbActive.addItem("--SELECCIONAR");
        vu.jcbActive.addItem("1");
        vu.jcbActive.addItem("0");
    }
}
