package Modelo.DAO;

import Modelo.DTO.Alumno;
import java.util.List;

public interface IAlumnoDAO {
    public boolean crearAlumno(Alumno alm);
    public boolean leerAlumno(Alumno alm);
    public boolean actualizarAlumno(Alumno alm);
    public boolean eliminarAlumno(Alumno alm);
    public List<Alumno> listarAlumno();
}
