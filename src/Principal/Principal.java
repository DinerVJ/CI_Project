package Principal;

import Controlador.ControladorLogin;
//import Modelo.DAO.ConexionBD;
import Vista.VistaLogin;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaLogin vl = new VistaLogin();
        ControladorLogin cl = new ControladorLogin(vl);
        cl.iniciar();
        vl.setVisible(true);
        vl.setLocationRelativeTo(null);
//        ConexionBD con = new ConexionBD();
//        con.conectar();
    }
    
}
