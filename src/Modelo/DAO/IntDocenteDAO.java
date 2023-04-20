package Modelo.DAO;

import Modelo.DTO.Docente;
import java.util.List;

public interface IntDocenteDAO {
    public boolean crearDocente(Docente dct);
    public boolean leerDocente(Docente dct);
    public boolean actualizarDocente(Docente dct);
    public boolean eliminarDocente(Docente dct);
    public List<Docente> listarDocente();
}
