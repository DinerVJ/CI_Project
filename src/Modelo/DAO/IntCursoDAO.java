package Modelo.DAO;

import Modelo.DTO.Curso;
import java.util.List;

public interface IntCursoDAO {
    public boolean crearCurso(Curso c);
    public boolean leerCurso(Curso c);
    public boolean actualizarCurso(Curso c);
    public boolean eliminarCurso(Curso c);
    public List<Curso> listarCurso();
}
