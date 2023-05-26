package Controlador;

import Modelo.DAO.ConexionBD;
import Vista.VistaLogin;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorLogin implements ActionListener {

    private VistaLogin vl;

    public ControladorLogin(VistaLogin vl) {
        this.vl = vl;
        this.vl.btnIngresar.addActionListener(this);
    }
    
    public void iniciar(){
        this.vl.setSize(600, 500);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = vl.jtxtUser.getText();
        String password = vl.jpwPassword.getText();
        String sql = "SELECT username, password, profile FROM usuario WHERE active=1 AND username='"+ user + "'";
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = ConexionBD.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                String u = rs.getString("username");
                String pass = rs.getString("password");
                String priv = rs.getString("profile");
                
                if (password.equals(pass)) {
                    if (priv.equals("ADMINISTRADOR")) {
                        VistaPrincipal vp = new VistaPrincipal();
                        //vp.setVisible(true);
                        vp.setLocationRelativeTo(null);
                    } else if (priv.equals("SECRETARIO/A")) {
                        VistaPrincipal vp = new VistaPrincipal();
                        vp.setVisible(true);
                        vp.setLocationRelativeTo(null);
                        vp.jmnDct.setVisible(false);
                    }
                } else {
                    System.out.println("Error");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
