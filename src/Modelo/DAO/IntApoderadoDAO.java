package Modelo.DAO;

import Modelo.DTO.Apoderado;
import java.util.List;

public interface IntApoderadoDAO {
    public boolean crearApoderado(Apoderado apd);
    public boolean leerApoderado(Apoderado apd);
    public boolean actualizarApoderado(Apoderado apd);
    public boolean eliminarApoderado(Apoderado apd);
    public List<Apoderado> listarApoderado();
}
