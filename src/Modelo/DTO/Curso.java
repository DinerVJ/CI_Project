
package Modelo.DTO;

public class Curso {
    private String codCur;
    private String nomCur;

    public Curso() {
    }
 
    public Curso(String codCur, String nomCur) {
        this.codCur = codCur;
        this.nomCur = nomCur;
    }

    public String getCodCur() {
        return codCur;
    }

    public void setCodCur(String codCur) {
        this.codCur = codCur;
    }

    public String getNomCur() {
        return nomCur;
    }

    public void setNomCur(String nomCur) {
        this.nomCur = nomCur;
    }
    
}
