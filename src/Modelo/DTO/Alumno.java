
package Modelo.DTO;

public class Alumno {
    private String dniAlm;
    private String apPatAlm;
    private String apMatAlm;
    private String nomAlm;
    private String sgNomAlm;
    private String fecNacAlm;
    private String dniApd;

    public Alumno(){
        
    }
    public Alumno(String dniAlm, String apPatAlm, String apMatAlm, String nomAlm, String sgNomAlm, String fecNacAlm, String dniApd) {
        this.dniAlm = dniAlm;
        this.apPatAlm = apPatAlm;
        this.apMatAlm = apMatAlm;
        this.nomAlm = nomAlm;
        this.sgNomAlm = sgNomAlm;
        this.fecNacAlm = fecNacAlm;
        this.dniApd = dniApd;
    }

    public String getDniAlm() {
        return dniAlm;
    }

    public void setDniAlm(String dniAlm) {
        this.dniAlm = dniAlm;
    }

    public String getApPatAlm() {
        return apPatAlm;
    }

    public void setApPatAlm(String apPatAlm) {
        this.apPatAlm = apPatAlm;
    }

    public String getApMatAlm() {
        return apMatAlm;
    }

    public void setApMatAlm(String apMatAlm) {
        this.apMatAlm = apMatAlm;
    }

    public String getNomAlm() {
        return nomAlm;
    }

    public void setNomAlm(String nomAlm) {
        this.nomAlm = nomAlm;
    }

    public String getSgNomAlm() {
        return sgNomAlm;
    }

    public void setSgNomAlm(String sgNomAlm) {
        this.sgNomAlm = sgNomAlm;
    }

    public String getFecNacAlm() {
        return fecNacAlm;
    }

    public void setFecNacAlm(String fecNacAlm) {
        this.fecNacAlm = fecNacAlm;
    }

    public String getDniApd() {
        return dniApd;
    }

    public void setDniApd(String dniApd) {
        this.dniApd = dniApd;
    }
    
    public Object[] registroAlumno(){
        Object[] fila = {dniAlm,apPatAlm,apMatAlm,nomAlm,sgNomAlm,fecNacAlm,dniApd};
        return fila;
    }
}
