
package Modelo.DAO;

import Modelo.DTO.Usuario;
import java.util.List;

public interface IntUsuarioDAO {
    public boolean crearUsuario(Usuario u);
    public boolean leerUsuario(Usuario u);
    public boolean actualizarUsuario(Usuario u);
    public boolean eliminarUsuario(Usuario u);
    public List<Usuario> listarUsuario();
}
