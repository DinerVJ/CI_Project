
package Modelo.DTO;

public class Curso {
    private int idCur;
    private String nomCur;

    public Curso() {
    }
 
    public Curso(int idCur, String nomCur) {
        this.idCur = idCur;
        this.nomCur = nomCur;
    }

    public int getIdCur() {
        return idCur;
    }

    public void setIdCur(int idCur) {
        this.idCur = idCur;
    }

    public String getNomCur() {
        return nomCur;
    }

    public void setNomCur(String nomCur) {
        this.nomCur = nomCur;
    }
    
}
